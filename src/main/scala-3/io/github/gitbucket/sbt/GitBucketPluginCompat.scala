package io.github.gitbucket.sbt

import java.io.File

private[sbt] object GitBucketPluginCompat {
  inline def toFile(f: xsbti.HashedVirtualFileRef): File =
    sbt.Keys.fileConverter.value.toPath(f).toFile
}
