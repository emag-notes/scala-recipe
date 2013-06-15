package collection

/**
 * Vector のサンプルです。
 */
object VectorSample extends App {

  val vector = Vector("A", "B", "C")

  // インデックスを指定して参照
  val e1 = vector(0)
  val e2 = vector(1)
  val e3 = vector(2)

  println(e1)
  println(e2)
  println(e3)

  // foreach メソッドで繰り返し処理
  vector.foreach { e =>
    println(e)
  }

  // インデックス=1 の要素を "*" に置換した Vector を生成
  val newVector = vector.updated(1, "*")
  println(newVector)
  
}
