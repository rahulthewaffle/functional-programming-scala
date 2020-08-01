course := "progfun1"
assignment := "funsets"

scalaVersion := "2.13.2"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, args = "-a", "-v", "-s")
