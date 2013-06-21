package io

/**
 * Java の入出力 API と Scala IO の API の相互運用のサンプルです。
 */
object JavaInterOpSample extends App {

  import scalax.io.Resource
  import scalax.io.Codec

  implicit val codec = Codec.UTF8

  java2scala()
  scala2java()

  /**
   * Java から Scala IO への変換のサンプルです。
   */
  def java2scala(): Unit = {
    // java.io.InputStream を Scala IO の Resource に変換
    val in = new java.io.FileInputStream("readme.txt")
    val inputResource = Resource.fromInputStream(in)

    println(inputResource.string)

    // java.io.OutputStream を Scala IO の Resource に変換
    val out = new java.io.ByteArrayOutputStream()
    val outputResource = Resource.fromOutputStream(out)

    outputResource.write("こんにちは, Scala IO!")
    println(new String(out.toByteArray, "UTF-8"))
  }

  /**
   * Scala IO から Java への変換のサンプルです。
   */
  def scala2java(): Unit = {
    val resource = Resource.fromFile("readme.txt")

    // Scala IO の Resource から java.io.InputStream を取得
    val in: java.io.InputStream = resource.inputStream.open().get
    in.close()

    // Scala IO の Resource から java.io.OutputStream を取得
    val out: java.io.OutputStream = resource.outputStream.open().get
    out.close()

    val result: Either[List[Throwable], String] =
      resource.inputStream.acquireFor { in: java.io.InputStream =>
        val bytes = new Array[Byte](resource.size.get.toInt)
        in.read(bytes)
        new String(bytes, "UTF-8")
      }

    result match {
      case Left(x)  => x.foreach { _.printStackTrace() }
      case Right(x) => println(x)
    }
  }

  /**
   * acquireFor メソッドを使用してストリームを安全にクローズするサンプルです。
   */
  def managedResourceSample(): Unit = {
    val resource = Resource.fromInputStream(new java.io.FileInputStream("reademe.txt"))

    val result: Either[List[Throwable], String] =
      resource.inputStream.acquireFor { in =>
        val bytes = new Array[Byte](in.available())
        in.read(bytes)
        new String(bytes, "UTF-8")
      }

    result match {
      // acquireFor に渡した処理内で例外が発生した場合
      case Left(x)  => x.foreach { _.printStackTrace() }
      // acquireFor に渡した処理から正常に値が返却された場合
      case Right(x) => println(x)
    }
  }



}
