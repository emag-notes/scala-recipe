package collection

/**
 * 配列(Array)のサンプルです。
 */
object ArraySample extends App {

  // ファクトリメソッドを使用して要素を 2 つ持つ String 型の配列を生成
  val array1 = Array("A", "B")

  val name1 = array1(0)
  val name2 = array1(1)
  println("name1: " + name1)
  println("name2: " + name2)

  for (e <- array1)
    println(e)

  // コンストラクタを使用して長さを指定して配列を宣言し、後から要素をセット
  val array2 = new Array[String](2)
  array2(0) = "A"
  array2(1) = "B"

  // 二次元配列
  val array3 = Array(Array("A", "B"), Array("C", "D"))

  for (x <- array3; y <- x)
    println(y)
}
