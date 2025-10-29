package io.github.gitbucket.sbt

import java.io.File

private[sbt] object GitBucketPluginCompat {
  def toFile(f: File): File = f
}
