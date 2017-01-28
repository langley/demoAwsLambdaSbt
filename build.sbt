
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  enablePlugins(AwsLambdaPlugin).
  settings(
    name := "demoAwsLambdaSbt",
    version := "1.0",
    scalaVersion := "2.11.8",
    retrieveManaged := true,
    awsLambdaMemory := Some(192),
    awsLambdaTimeout := Some(30),
    lambdaHandlers := Seq("awsLambdSbt_respondToAwsS3PutEvent" -> "example.Main::respondToAwsS3PutEvent"),
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0"
  )

mergeStrategy in assembly :=
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }

