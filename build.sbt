name := "problem_manager_api"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings
