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

  override lazy val projectSettings: Seq[Def.Setting[_]] = Seq(
    install := GitBucketPluginTasks.installTask(install).value,
    libraryDependencies += {
      "io.github.gitbucket" %% "gitbucket" % gitbucketVersion.value % "provided"
    }
  ) ++ SbtTwirl.projectSettings

}
