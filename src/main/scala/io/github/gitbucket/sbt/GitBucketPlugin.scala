package io.github.gitbucket.sbt

import sbt._
import Keys._
import play.twirl.sbt.SbtTwirl
import sbtassembly.AssemblyPlugin

object GitBucketPlugin extends sbt.AutoPlugin {
  override def requires = AssemblyPlugin /*&& SbtTwirl*/
  override def trigger = allRequirements

  object autoImport extends GitBucketPluginKeys
  import autoImport._
  import AssemblyPlugin.autoImport._

  override lazy val projectSettings: Seq[Def.Setting[_]] = Seq(
    install := GitBucketPluginTasks.installTask(install).value,
    libraryDependencies ++= Seq(
      "io.github.gitbucket" %% "gitbucket" % gitbucketVersion.value % "provided",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
    ),
    resolvers += Resolver.bintrayRepo("bkromhout", "maven"),
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false, includeDependency = true),
    assemblyJarName in assembly := name.value + "-gitbucket_" + gitbucketVersion.value + "-" + version.value + ".jar"
  ) ++ SbtTwirl.projectSettings.filterNot(_.key.key == libraryDependencies.key)

}
