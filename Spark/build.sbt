ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Spark"
  )

libraryDependencies ++= {
  val sparkVer = "3.2.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer
  )
}