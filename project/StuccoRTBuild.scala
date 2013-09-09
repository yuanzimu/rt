import sbt._
import Keys._

object StuccoRTBuild extends Build {
  lazy val root = Project("root", file("."))
    .dependsOn(morph)
    .dependsOn(extractors)

  // example:
  // lazy val config = GitHub("typesafehub", "config", "master")
  lazy val morph = GitHub("stucco", "morph", "master")
  lazy val extractors = GitHub("stucco", "extractors", "master")

  def GitHub(user: String, project: String, tag: String) =
      RootProject(
        uri("https://github.com/%s/%s.git#%s".format(user, project, tag))
      )
}