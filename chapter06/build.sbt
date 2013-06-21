name := "chapter06"

version := "0.0.1"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.2",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2"
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
