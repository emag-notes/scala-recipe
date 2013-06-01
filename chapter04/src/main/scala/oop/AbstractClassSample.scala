package oop

/**
 * 抽象クラスのサンプルです。
 */
abstract class AbstractClass {
  // 抽象フィールド
  val value: String

  // 抽象メソッド
  def hello(arg: String): String
  def helloUnit(arg: String)  // 戻り値を指定しない場合は Unit になる
}

// 具象クラス
class ConcreteClass extends AbstractClass {
  // 抽象フィールドを実装
  val value = "hello"

  // 抽象メソッド を実装
  def hello(arg: String): String = "hello: " + arg
  def helloUnit(arg: String) = println("hello: " + arg)
}
