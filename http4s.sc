import $file.catsEffect, catsEffect._

import cats.effect._
import scala.concurrent.ExecutionContext.global

implicit val cs: ContextShift[IO] = IO.contextShift(global)
implicit val timer: Timer[IO] = IO.timer(global)

import org.http4s.client.Client
import org.http4s.client.JavaNetClientBuilder
import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors

val blockingEC = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(5))
val httpClient: Client[IO] = JavaNetClientBuilder[IO](blockingEC).create

@

// 以下不会执行，要不要上面的`@`符号都不会执行。
import org.http4s.Uri
httpClient.expect[String](Uri.uri("https://www.so.com/")).unsafeRunSync

