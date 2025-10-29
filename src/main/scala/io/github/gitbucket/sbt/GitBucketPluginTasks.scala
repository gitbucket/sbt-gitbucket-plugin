package io.github.gitbucket.sbt

import sbt._
import Keys._
import Def.Initialize
import sbtassembly.AssemblyKeys.assembly

object GitBucketPluginTasks {
  def installTask(key: TaskKey[Unit]): Initialize[Task[Unit]] = Def.task {
    val file = GitBucketPluginCompat.toFile(assembly.value)

    val GitBucketHome = (System.getProperty("gitbucket.home") match {
      // -Dgitbucket.home=<path>
      case path if(path != null) => new File(path)
      case _ => scala.util.Properties.envOrNone("GITBUCKET_HOME") match {
        // environment variable GITBUCKET_HOME
        case Some(env) => new File(env)
        // default is HOME/.gitbucket
        case None => {
          val oldHome = new File(System.getProperty("user.home"), "gitbucket")
          if(oldHome.exists && oldHome.isDirectory && new File(oldHome, "version").exists){
            //FileUtils.moveDirectory(oldHome, newHome)
            oldHome
          } else {
            new File(System.getProperty("user.home"), ".gitbucket")
          }
        }
      }
    })

    val PluginDir = new File(GitBucketHome, "plugins")
    if(!PluginDir.exists){
      PluginDir.mkdirs()
    }

    val log = streams.value.log
    log.info(s"Copying ${file.getAbsolutePath} to ${PluginDir.getAbsolutePath}")

    IO.copyFile(file, new File(PluginDir, file.getName))

    ()
  }

}
