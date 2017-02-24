name := "MonsterTruckBot"

organization := "com.cobble.bot"

version := "1.0.0-SNAPSHOT"

val logbackVersion: String = "1.2.1"

resolvers ++= Seq(
    Resolver.jcenterRepo,
    "jitpack" at "https://jitpack.io"
)

libraryDependencies ++= Seq(
    "com.github.austinv11" % "Discord4j" % "2.7.0",
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion
)

isSnapshot := version.value.toLowerCase.contains("snapshot")

target in Compile in doc := baseDirectory.value / "docs"

crossPaths := false

autoAPIMappings := true

apiMappings += (scalaInstance.value.libraryJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/"))

scalaVersion := "2.12.1"