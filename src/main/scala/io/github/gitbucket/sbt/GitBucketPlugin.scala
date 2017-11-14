package io.github.gitbucket.sbt

import sbt._
import Keys._

object GitBucketPlugin extends sbt.AutoPlugin {
  override def requires = sbtassembly.AssemblyPlugin
  override def trigger = allRequirements

  object autoImport extends GitBucketPluginKeys {
    val GitBucketPlugin = _root_.io.github.gitbucket.sbt.GitBucketPluginTasks
  }
  import autoImport.{ GitBucketPlugin => _, _ }

  override lazy val projectSettings: Seq[Def.Setting[_]] = Seq(
    install := GitBucketPluginTasks.installTask(install).value,
    libraryDependencies += {
      "io.github.gitbucket" %% "gitbucket" % gitbucketVersion.value % "provided"
    }
  )
}
