package io

/**
 * バイナリファイルの読み書きのサンプルです。
 */
object BinaryFileSample extends App {

  {
    import scalax.file.Path

    // ファイルをバイト配列として読み込む
    val path  = Path("readme.txt")
    val bytes = path.byteArray

    println(new String(bytes, "UTF-8"))

    // ファイルを 1 バイトずつ読み込む
    val out = new java.io.ByteArrayOutputStream()
    path.bytes.foreach { byte =>
      out.write(byte)
    }
    println(new String(out.toByteArray), "UTF-8")
  }

  {
    import scalax.file.Path

    val path  = Path("hoge.txt")
    val bytes = "Hello, Scala IO!".getBytes()

    // ファイルにバイト配列を書き出し
    path.write(bytes)
    // ファイルにバイト配列を追加
    path.append(bytes)
  }

  {
    import scalax.file.Path

    // プロセッサを利用した逐次書き出しの例
    for {
      processor <- Path("output.txt").outputProcessor
      out = processor.asOutput
    } {
      out.write("Hello\n")
      out.write("World\n")
    }
  }

}
