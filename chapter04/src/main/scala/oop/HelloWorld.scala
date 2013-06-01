package oop

/**
 * Scala のクラスのサンプルです。
 */
class HelloWorld(x: Int, y: Int) {  // 基本コンストラクタ(引数あり)
  // ここにコンストラクタの処理を書く
  println(x + y)

  /*
   * 補助コンストラクタ
   */
  def this(z: Int) = {
    this(z, 0)  // 基本コンストラクタを呼び出す
    println("補助コンストラクタ")
  }

  /*
   * メソッドを定義
   */
  // 式が 1 つの場合、1 行で書ける
  def greet1(arg: String): String = "Hello World " + arg

  // 通常、戻り値の型は推論できるので省略可能
  def greet2(arg: String) = "Hello World" + arg

  // 引数なしの場合
  def printHello() = println("Hello World")

  // 引数なし、かつ副作用がない(たとえば値の取得を目的とするメソッド)場合、
  // 丸括弧()を省略するのが監修
  def hello = "Hello World"
}
