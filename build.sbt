name := "my_first_scala_exercices"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "com.github.haifengl" %% "smile-scala" % "1.5.3",
  "com.github.haifengl" % "smile-scala_2.12" % "1.5.3",
  "com.github.haifengl" % "smile-core" % "1.5.3",
  "com.github.haifengl" % "smile-plot" % "1.5.3",
  "com.github.haifengl" % "smile-netlib" % "1.5.3"
)
