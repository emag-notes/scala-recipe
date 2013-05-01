package other

import java.io.{IOException, FileInputStream, InputStream}

object ExceptionSample extends App {

  /**
   * try - catch による例外処理の例
   */
  println("-- try - catch による例外処理の例 --")
  val in: InputStream = new FileInputStream("build.sbt")

  // try 式は値を返すことができる
  val content: String = try {
    val buf: Array[Byte] = new Array[Byte](in.available())
    in.read(buf)
    new String(buf, "UTF-8")
  } catch {
    // IOException の場合
    case e: IOException => e.toString
    // それ以外の例外の場合
    case e: Exception => e.toString
  } finally {
    in.close
  }

  println(content)

  /**
   * Either を使用した例外処理の例
   */
  println("-- Either を使用した例外処理の例 --")
  val result: Either[Throwable, String] = readFile("build.sbt")
  result match {
    case Left(e) => e.toString
    case Right(s) => println(s)
  }

  // 戻り値は Throwable, String のどちらかを格納した Either
  def readFile(fileName: String): Either[Throwable, String] = {
    val in: InputStream = new FileInputStream(fileName)
    try {
      val buf = new Array[Byte](in.available())
      in.read(buf)
      // 処理が成功した場合、Right() で結果を返す
      Right(new String(buf, "UTF-8"))
    } catch {
      // 例外が発生した場合、Left() で例外を返す
      case e => Left(e)
    } finally {
      in.close
    }
  }
}
