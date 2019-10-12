import interp._
import ammonite.ops._

repositories() ++= Seq(coursierapi.MavenRepository.of("https://jitpack.io/"))

val aaaa = 0

{
  val http4sVersion = "0.20.11"
  Seq(
    "org.http4s"      %% "http4s-prometheus-metrics" % http4sVersion,
    "org.http4s"      %% "http4s-dropwizard-metrics" % http4sVersion,
    "org.http4s"      %% "http4s-blaze-server" % http4sVersion,
    "org.http4s"      %% "http4s-blaze-client" % http4sVersion,
    "org.http4s"      %% "http4s-circe"        % http4sVersion,
    "org.http4s"      %% "http4s-dsl"          % http4sVersion,
  ).foreach(load.ivy(_))
}

@ // 等待 loading...

val dddd = 3 // @ 后面定义的变量是不起作用的，所以 httpClient 的定义也不能写在这一个文件里面。

