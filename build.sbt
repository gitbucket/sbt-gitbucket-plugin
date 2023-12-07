organization := "io.github.gitbucket"
name := "sbt-gitbucket-plugin"
version := "1.6.0"
sbtPlugin := true
libraryDependencies ++= Seq(
  Defaults.sbtPluginExtra(
    "com.eed3si9n" % "sbt-assembly" % "2.1.5",
    (pluginCrossBuild / sbtBinaryVersion).value,
    (pluginCrossBuild / scalaBinaryVersion).value
  ),
  Defaults.sbtPluginExtra(
    "org.playframework.twirl" % "sbt-twirl" % "2.0.3",
    (pluginCrossBuild / sbtBinaryVersion).value,
    (pluginCrossBuild / scalaBinaryVersion).value
  ),
)
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
publishMavenStyle := true
pomIncludeRepository := { x => false }
pomExtra := (<url>https://github.com/gitbucket/sbt-gitbucket-plugin/</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:gitbucket/sbt-gitbucket-plugin.git</url>
    <connection>scm:git:git@github.com:gitbucket/sbt-gitbucket-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>takezoe</id>
      <name>Naoki Takezoe</name>
      <url>https://github.com/takezoe</url>
    </developer>
  </developers>
)
