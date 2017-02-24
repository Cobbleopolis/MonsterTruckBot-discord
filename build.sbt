name := "MonsterTruckBot"

organization := "com.cobble.bot"

version := "1.0.0-SNAPSHOT"

resolvers ++= Seq(
    Resolver.jcenterRepo,
    "jitpack" at "https://jitpack.io"
)

libraryDependencies ++= Seq(
    "com.github.austinv11" % "Discord4j" % "2.7.0"
)

isSnapshot := version.value.toLowerCase.contains("snapshot")

target in Compile in doc := baseDirectory.value / "docs"

crossPaths := false

autoAPIMappings := true

apiMappings += (scalaInstance.value.libraryJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/"))

scalaVersion := "2.12.1"