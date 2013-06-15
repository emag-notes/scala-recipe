package collection

/**
 * コレクション同士の変換のサンプルです。
 */
object ConvertSample extends App {

  {
    // List を配列に変換
    println("■ List を配列に変換")
    val list = List("A", "B", "C")
    val array = list.toArray

    println(array)
  }

  {
    // Map を List に変換
    println("■ Map を List に変換")
    val map = Map(1 -> "A", 2 -> "B")
    val list = map.toList

    println(list)
  }

  {
    // List を Map に変換
    println("■ List を Map に変換")
    val list = List((1, "A"), (2, "B"))
    val map = list.toMap

    println(map)
  }

}
