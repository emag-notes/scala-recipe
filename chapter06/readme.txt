import scala.io._

// ファイルからSourceのインスタンスを生成
val source = Source.fromFile("readme.txt", "UTF-8")

try {
  // 1行毎の文字列を返すIteratorを取得して表示
  source.getLines().foreach { line: String =>
    println(line)
  }
} finally {
  // クローズ
  source.close()
}