sbt-gitbucket-plugin
========

This sbt plugin supports GitBucket plugin development.

Add a following line to your GitBucket plugin's `project/plugin.sbt`:

```scala
addSbtPlugin("io.github.gitbucket" % "sbt-gitbucket-plugin" % "0.1-SNAPSHOT")
```

This plugin provides following functionality in your GitBucket plugin project: 

- Enables [sbt-assembly](https://github.com/sbt/sbt-assembly) plugin to package your GitBucket plugin
- Enables `sbt install` task to build and install the GitBucket plugin to the local GitBucket instance

### TODO

- Add GitBucket core library dependency to the project as "provided" scope
- Enable sbt-twirl plugin automatically
