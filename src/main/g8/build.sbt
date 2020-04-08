// give the user a nice default project!
ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scalaVersion$"

val DeclineVersion       = "$declineVersion$"
val RasterFoundryVersion = "$rfVersion$"
val SttpVersion          = "$sttpVersion$"

val cliDependencies = List(
  "com.monovore"                 %% "decline"                        % DeclineVersion,
  "com.monovore"                 %% "decline-effect"                 % DeclineVersion,
  "com.rasterfoundry"            %% "datamodel"                      % RasterFoundryVersion,
  "com.softwaremill.sttp.client" %% "async-http-client-backend-cats" % SttpVersion,
  "com.softwaremill.sttp.client" %% "core"                           % SttpVersion
)

lazy val cli = (project in file("./cli"))
  .settings(
    libraryDependencies ++= cliDependencies,
    externalResolvers ++= Seq(
      DefaultMavenRepository,
      Resolver.sonatypeRepo("snapshots"),
      Resolver.bintrayRepo("azavea", "maven"),
      Resolver.bintrayRepo("azavea", "geotrellis"),
      "locationtech-releases" at "https://repo.locationtech.org/content/groups/releases",
      "locationtech-snapshots" at "https://repo.locationtech.org/content/groups/snapshots",
      Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(
        Resolver.ivyStylePatterns
      )
    )
  )
