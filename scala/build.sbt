name := "scala-tdd"

version := "0.1"

scalaVersion := "2.12.6"

val scalaTestVersion = "3.0.5"

libraryDependencies += "org.scalactic" %% "scalactic" % scalaTestVersion
libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

libraryDependencies ++= Seq(
	"eu.timepit" %% "refined" % "0.9.10",
	"eu.timepit" %% "refined-scalacheck" % "0.9.10", // optional
)
