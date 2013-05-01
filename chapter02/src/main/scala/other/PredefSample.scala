package other

object PredefSample extends App {

  // コンソールから1行分出力
  val name: String = readLine("Input your name: ")
  // メッセージをコンソールに出力
  printf("Hello %s!\n", name)

  // フォーマットを指定してコンソールから入力
  print("Input two words(?,?): ")
  val result: List[Any] = readf("{0},{1}")
  result.foreach { a: Any => println(a) }

  // メソッドの引数をアサートする
  printMessage("Hello")
  printMessage(null)  // ここで AssertionError が発生する
  def printMessage(message: String): Unit = {
    // message が null でないことをアサート
    assert(message != null, "引数 message は null であってはいけません")

    println(message)
  }

}
