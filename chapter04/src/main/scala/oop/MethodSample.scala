package oop

/**
 * 様々なメソッド呼び出しのサンプルです。
 */
object MethodSample extends App {
  /*
   * インスタンスを生成してメソッドを呼び出す
   */
  val instance = new HelloWorld(1, 2)

  println(instance.greet1("name"))
  println(instance greet1("name"))  // ピリオドは省略可能

  // 引数が 1 つの場合、丸括弧()も省略可能
  // このような呼び出し方を「中値演算子記法(中値記法)」と呼び、メソッドチェーンに適している。
  println(instance greet1 "name")

  // 引数が 1 つの場合、波括弧を{}を利用しても良い
  // 引数に関数リテラルのような制御構造を渡す場合に適している。
  val flag = false
  println(instance.greet1{if (flag) "name" else "guest"})

  // 引数なしの場合、丸括弧()は指定/省略のどちらでも良い
  instance.printHello()
  instance.printHello

  // ただし、メソッド定義で丸括弧()を省略した場合、必ず丸括弧()を省略
  println(instance.hello)

  /*
   * 可変長引数のメソッド
   */
  def args(values: String*) = for (s <- values) println(s)

  args()
  args("a")
  args("a", "b")

  val list = List("a", "b", "c")
  args(list: _*)

  /*
   * 引数名を指定してメソッドを呼び出す
   */
  def tax(total: Int, rate: BigDecimal, discount: Int) = (total - discount) * rate

  // 引数の定義順とは異なる順序で呼び出し可能
  println(tax(rate = BigDecimal(0.05), discount = 500, total = 10000))

  // 一部に引数名を指定した呼び出しも可能
  println(tax(10000, discount = 500, rate = BigDecimal(0.05)))

  /*
   * 引数にデフォルト値を設定
   */
  def flat(total: Int = 10000, discount: Int = 500) = total - discount
  // total のみデフォルト値を適用
  println(flat(discount = 1000))  // 名前付き引数を利用

  // discount のみデフォルト値を適用
  println(flat(5000))
  println(flat(total = 5000))

  // すべての引数にデフォルト値を適用
  println(flat()) // 丸括弧()は省略不可

  import java.util.Calendar

  def priceDay(total: Int, discount: Int =
                if (Calendar.getInstance.get(Calendar.DATE) % 2 == 0) 500
                else 100) =
    total - discount

  println(priceDay(10000))

  /*
   * 引数を遅延評価にする
   */
  def lazyParam(execute: Boolean, f: => Unit) =
    if (execute) f

  lazyParam(true, println("Hello, Lazy1"))
  lazyParam(false, println("Hello, Lazy2"))

  def noLazyParam(execute: Boolean, f: Unit) =
    if (execute) f

  noLazyParam(true, println("Hello, No Lazy1"))
  noLazyParam(false, println("Hello, No Lazy2"))
}
