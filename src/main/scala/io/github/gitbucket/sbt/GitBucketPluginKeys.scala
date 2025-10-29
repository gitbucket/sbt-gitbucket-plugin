package io.github.gitbucket.sbt

import sbt._

trait GitBucketPluginKeys {
  lazy val gitbucketVersion = settingKey[String]("GitBucket version")
  @transient
  lazy val install = taskKey[Unit]("Install the plugin to a local GitBucket instance.")
}
