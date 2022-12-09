organization := "io.github.gitbucket"
name := "sbt-gitbucket-plugin"
version := "1.5.1"
sbtPlugin := true
libraryDependencies ++= Seq(
  Defaults.sbtPluginExtra(
    "com.eed3si9n" % "sbt-assembly" % "2.1.0",
    (sbtBinaryVersion in pluginCrossBuild).value,
    (scalaBinaryVersion in pluginCrossBuild).value
  ),
  Defaults.sbtPluginExtra(
    "com.typesafe.sbt" % "sbt-twirl" % "1.5.1",
    (sbtBinaryVersion in pluginCrossBuild).value,
    (scalaBinaryVersion in pluginCrossBuild).value
  ),
)
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
publishTo := {
  if (version.value.trim.endsWith("SNAPSHOT")) Some(Opts.resolver.sonatypeSnapshots)
  else Some(Opts.resolver.sonatypeStaging)
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
