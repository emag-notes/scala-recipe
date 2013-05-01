package other

object LazySample extends App {

  var i = 1

  // 普通は宣言時に計算される
  val x = i * 2
  // lazy の場合、ここでは計算されない
  lazy val y = i + 2

  i = 2

  println("i: 2")
  println("x: " + x)
  println("y: " + y)  // ここで計算される

  i = 3

  println("i: 3")
  println("x: " + x)
  println("y: " + y)  // 再計算はされない

}
