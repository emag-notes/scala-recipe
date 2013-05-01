package string

object StringLinesSample extends App {

  // 処理対象の文字列
  val source = "1行目\n2行目\n3行目"

  // 1行ずつ繰り返し処理(改行文字なし)
  source.lines.foreach {
    line: String => println(line)
  }

  // 1行ずつ繰り返し処理(改行文字付き)
  source.linesWithSeparators.foreach {
    line => print(line)
  }

}
