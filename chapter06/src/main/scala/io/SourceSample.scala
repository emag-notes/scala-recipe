package io

object SourceSample extends App {

  import scala.io._

  {
    println("-- ファイルの内容を読込み --")

    // ファイルから Source のインスタンスを生成
    val source = Source.fromFile("readme.txt", "UTF-8")

    try {
      // 1行ごとの文字列を返す Iterator を取得して表示
      source.getLines().foreach { line: String =>
        println(line)
      }
    } finally {
      // クローズ
      source.close
    }
  }

  {
    println("-- 空行を除去 --")

    val source1 = Source.fromFile("readme.txt", "UTF-8")
    // filter メソッドで空行を除去して表示
    source1.getLines().filter { _ != ""} foreach { line: String =>
      println(line)
    }
    source1.close

    println("-- 行番号付きで表示 --")

    val source2 = Source.fromFile("readme.txt", "UTF-8")
    // zipWithIndex と map メソッドで行番号付きに変換
    val linesWithIndex =
      source2.getLines().zipWithIndex.map { case(line, index) =>
        "%02d: %s".format(index + 1, line)
      }
    linesWithIndex.foreach { println _ }
    source2.close
  }

  {
    println("-- 指定した URL から読込み --")
    // 指定した URL から読込み
    val source1 = Source.fromURL("http://emamotor.blogspot.jp/", "UTF-8")
    println(source1.mkString)
    source1.close

    println("-- InputStream から読込み --")
    // InputStream から読込み
    val source2 = Source.fromInputStream(
      getClass.getResourceAsStream("/config.properties"))
    println(source2.mkString)
    source2.close

    println("-- バイト配列から読込み --")
    // バイト配列から読込み
    val source3 = Source.fromBytes("Hello, Scala!".getBytes)
    println(source3.mkString)
    source3.close
  }

}
