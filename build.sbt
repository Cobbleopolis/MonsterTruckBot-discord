name := "MonsterTruckBot"

organization := "com.cobble.bot"

version := "1.0.0-SNAPSHOT"

val logbackVersion: String = "1.2.1"

val discord4JVersion: String = "2.7.0"

val deps: Seq[ModuleID] = Seq(
    "com.github.austinv11" % "Discord4j" % discord4JVersion,
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion
)

resolvers ++= Seq(
    Resolver.jcenterRepo,
    "jitpack" at "https://jitpack.io"
)

libraryDependencies ++= deps

apiURL := Some(url("https://cobbleopolis.github.io/MonsterTruckBot"))

isSnapshot := version.value.toLowerCase.contains("snapshot")

target in Compile in doc := baseDirectory.value / "docs"

crossPaths := false

autoAPIMappings := true

apiMappings += (scalaInstance.value.libraryJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/"))

apiMappings ++= {
    val cp: Seq[Attributed[File]] = (fullClasspath in Compile).value
    def findManagedDependency(organization: String, name: String): File = {
        ( for {
            entry <- cp
            module <- entry.get(moduleID.key)
            if module.organization == organization
            if module.name.startsWith(name)
            jarFile = entry.data
        } yield jarFile
            ).head
    }
    Map(
        findManagedDependency("com.github.austinv11", "Discord4j") -> url(s"https://jitpack.io/com/github/austinv11/Discord4j/$discord4JVersion/javadoc/")
    )
}

scalaVersion := "2.12.1"