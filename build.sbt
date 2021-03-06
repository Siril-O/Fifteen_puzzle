
name := "Fifteen_puzzle"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
libraryDependencies += "org.mockito" %% "mockito-scala-scalatest" % "1.7.1" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "3.1.0" % Test

mainClass := Some("com.ua.fpuzzle.Start")
