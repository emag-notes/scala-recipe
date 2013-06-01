package oop

/**
 * 列挙型のサンプルです。
 */
object Sex extends Enumeration {
  type Sex = Value
  val Man, Woman = Value
}

object EnumerationSample extends App {
  import Sex._

  // 列挙子の名前
  println(Man.toString)

  // 列挙子の ID
  println(Man.id)
  println(Woman.id)

  // 列挙子の名前から列挙子を取得
  val man = Sex.withName("Man")

  // 列挙子の ID から列挙子を取得
  val woman = Sex(1)

  // すべての列挙子を取得
  def printSex = Sex.values foreach println
  printSex
}
