package io

/**
 * テキストファイルの読み書きのサンプルです。
 */
object TextFIleSample extends App {

  {
    import scalax.file.Path

    // ファイルを文字列として読込む
    val path = Path("readme.txt")
    val str = path.string
    println(str)

    // ファイルを 1 行ずつ読込む
    path.lines().foreach { line =>
      println(line)
    }
  }

  {
    import scalax.file.Path

    // ファイルに文字列を書き出す
    val path = Path("hoge.txt")

    // ファイルに文字列を出力
    path.write("ファイルに文字列を出力")
    // ファイルに文字列を追加
    path.append("ファイルに文字列を追加")
  }

  {
    // Core API によるファイルの入出力
    import scalax.io.Resource

    val resource = Resource.fromFile("hoge.txt")

    // ファイルに文字列を書き出す
    resource.write("Hello ,Scala IO!")
    // ファイルから文字列として読込む
    println(resource.string)
  }

  {
    // Scala IO での入出力処理の文字コードの指定方法
    import scalax.file.Path
    import scalax.io.Codec

    implicit val codec = Codec("UTF-8")

    val path = Path("readme.txt")
    val str1 = path.string
    println(str1)

    // Codec を直接渡すこともできる
    val str2 = path.string(Codec("UTF-8"))
    println(str2)
  }
}
