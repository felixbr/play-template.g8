lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        scalaVersion := "2.11.8",
        cancelable in Global := true
      )
    ),
    name := """$name$""",
    version := "0.1.0",
    resolvers ++= List(
      "Bintary JCenter" at "http://jcenter.bintray.com"
    ),
    libraryDependencies ++= List(
      "io.github.felixbr"  %% "swagger-blocks-play" % "0.3.0",
      "play-circe"         %% "play-circe"          % "2.5-0.6.0",
      "io.circe"           %% "circe-java8"         % "0.6.1",
      "org.typelevel"      %% "cats"                % "0.8.1",
      "com.github.melrief" %% "pureconfig"          % "0.5.0",
      "com.lihaoyi"        %% "pprint"              % "0.4.3",
      jdbc,
      cache,
      ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0-M1" % Test
    )
  )
  .settings(dockerSettings: _*)
  .enablePlugins(PlayScala)

lazy val dockerSettings = List(
  dockerBaseImage := "openjdk:8-jre",
  maintainer := "$maintainer$ <$maintainer_email$>",
  daemonUser := "root",
  dockerExposedPorts := List(9000),
  aggregate in Docker := false
)
