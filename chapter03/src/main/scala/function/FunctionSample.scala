package function

/**
 * 様々な関数のサンプルです。
 */
object FunctionSample extends App {
  /*
   * 関数の定義
   */
  println("-- 関数の定義 --")
  // 式が 1 つの場合、1 行で書ける
  val f = (i: Int) => i * 2

  // 引数の型が推論できる場合、省略可能
  val f2: Int => Int = (i) => i * 2

  // 引数の型を省略、かつ引数が 1 つの場合、丸括弧も省略可能
  val f3: Int => Int = i => i * 2

  // 引数の使用が 1 回のみの場合、プレースホルダ構文を利用可能
  val f4: Int => Int = _ * 2

  // 引数が複数の場合もプレースホルダ構文を利用可能
  // n 番目のプレースホルダが n 番目の引数となり、引数は定義順に 1 回のみ使用する
  val f5 = (_: Int) + (_: Int)

  // 引数なしの場合
  val f6 = () => println("Hello World")

  // Functional#andTHen メソッドで引数を 2 倍にした後にコンソールへ出力
  val f7 = ((_: Int) * 2).andThen(println)

  println(f(10))
  println(f2(20))
  println(f3(30))
  println(f4(40))
  println(f5(50, 50))
  f6()
  f7(10)

  /*
   * メソッドの引数に関数型を定義
   */
  println("-- メソッドの引数に関数型を定義 --")
  // 引数は Int => Boolean の関数
  def execute1(f: (Int) => Boolean) = f(10)

  // 引数が 1 つの場合、丸括弧()を省略可能
  def execute2(f: Int => Boolean) = f(21)

  // 引数なしの場合
  def execute3(f: () => Unit) = f()

  println(execute1(i => (i % 2) == 0))
  println(execute2(_ % 2 == 0))
  execute3(() => println("Hoge"))

  /*
   * 戻り値を関数型にする
   */
  println("-- 戻り値を関数型にする --")
  // 戻り値は Int => Int(引数が Int で Int を返す)の関数
  def double1: Int => Int = {
    (i: Int) => i * 2
  }

  // 戻り値を省略
  def double2 = (i: Int) => i * 2

  // プレースホルダ構文を利用
  def double3: Int => Int = _ * 2

  println(double1(10))
  println(double2(20))
  println(double3(30))

  /*
   * ネストした関数の定義
   */
  println("-- ネストした関数の定義 --")

  def list(capital: String) = {
    // ローカル関数は外側の関数の引数にアクセス可能
    def isTokyo(address: String) = address contains capital

    println(isTokyo("Shibuya, Shibuya-ku, Tokyo"))
    println(isTokyo("Kanagawa, Kanagawa-ku, Yokohama, Kanagawa"))
  }

  // 実行
  list("Tokyo")
//  isTokyo("Tokyo") コンパイルエラー。list 以外からローカル関数にはアクセス不可
}
