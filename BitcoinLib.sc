import ammonite.ops._
import interp._

repositories() ++= Seq(coursierapi.MavenRepository.of("https://jitpack.io/"))

println("加载 bitcoinj ...")
load.ivy("com.github.dedge-space" % "bitcoinj" % "33b5d94bfc")

println("加载 reflow ...")
load.ivy("com.github.dedge-space" % "reflow" % "dc5b40e255")

@ // 用于等待签名加载完成。

import org.bitcoinj.core._
import org.bitcoinj.params.MainNetParams
import org.spongycastle.util.encoders._

import java.util.Arrays
import java.math.BigInteger

def hash256(bytes: Array[Byte]) = Sha256Hash.hash(bytes).map{b => String.format("%02x", Integer.valueOf(b & 0xff))}.mkString

def hash256$160(bytes: Array[Byte]) = Utils.sha256hash160(bytes).map{b => String.format("%02x", Integer.valueOf(b & 0xff))}.mkString

// 变量和方法可以在不同`.sc`文件中互相引用，但不可以引用到`REPL`环境中。
val text = "测试测试测试测试"
println("hash256(\"中成才\".getBytes()): " + hash256("中成才".getBytes()))

println(s"text: $text")

println("`BitcoinLib.sc`加载完成。")
