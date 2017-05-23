name := "rock-paper-scissors"
version := "1.0.1"

scalaVersion in ThisBuild := "2.11.8"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

// Dependencies
libraryDependencies ++= Seq(
  filters,
  cache,
  // WebJars (i.e. client-side) dependencies
  "org.webjars" % "requirejs" % "2.3.2",
  //"org.webjars" % "underscorejs" % "1.8.3",
  "org.webjars" % "jquery" % "1.12.4",
  "org.webjars" % "bootstrap" % "3.3.7-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.4.10" exclude("org.webjars", "jquery")
)

// Scala Compiler Options
scalacOptions in ThisBuild ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Xcheckinit",
  "-Ywarn-adapted-args",
  "-Ywarn-value-discard",
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-numeric-widen"
)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test"
)

pipelineStages := Seq(rjs, digest, gzip)
RjsKeys.paths += ("jsRoutes" -> ("/jsroutes" -> "empty:"))
emojiLogs
