package string

object StringFormatSample extends App {

  // 文字列のフォーマット
  println("Hello %s!".format("Scala"))

  // パラメータの位置を指定
  println("%2$sは%1$d文字以内で入力してください。".format(20, "お名前"))

  // 数値のフォーマット
  println("%04d/%02d/%02d".format(2012, 1, 2))
  println("%06.2f".format(10.0d))

}
