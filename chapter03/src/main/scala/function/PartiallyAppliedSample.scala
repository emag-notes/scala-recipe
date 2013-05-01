package function

/**
 * 部分適用のサンプルです。
 */
object PartiallyAppliedSample extends App {
  /*
   * 部分適用
   */
  println("-- 部分適用 --")
  def price(total: Int, discount: Int) = total - discount

  // 第 2 引数(discount)のみ省略
  val f1 = price(1000, _: Int)
  // すべての引数を省略
  val f2 = price _

  // discount のみ指定
  println(f1(500))
  // すべての引数を指定
  println(f2(1000, 500))

  /*
   * 部分関数を定義
   */
  println("-- 部分関数を定義 --")
  // IllegalArgumentException か IllegalStateException の場合のみ値をを返す
  val base: PartialFunction[Throwable, String] = {
    case _: IllegalArgumentException => "Parameter is invalid."
    case _: IllegalStateException    => "State is invalid."
  }

  // 常に値を返す
  val ex: PartialFunction[Throwable, String] = {
    case _ => "No support."
  }

  // base の PartialFunction を利用
  def check(i: Int) = {
    try {
      if (i < 0) throw new IllegalArgumentException
      else i / 0
      "success"
    } catch base orElse ex  // orElse メソッドで複数の PartialFunction を連結できる
  }

  println(check(-2))
  println(check(2))

}