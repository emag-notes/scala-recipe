package collection

/**
 * ミュータブルなコレクションのサンプルです。
 */
object MutableSample extends App {

  /**
   * ミュータブルな List を使用する
   */
  import scala.collection.mutable.{ ListBuffer, ArrayBuffer }

  println("-- ListBuffer --")

  // ミュータブルな List を生成
  val list = ListBuffer("A", "B")
  // 先頭に要素を追加
  "Z" +=: list
  // 末尾に要素を追加
  list += "C"
  // 先頭に複数の要素を一度に追加
  List("X", "Y") ++=: list
  // 末尾に複数の要素を一度に追加
  list ++= List("D", "E")
  // インデックスを指定して要素を追加
  list(4) = "b"
  // 要素を削除
  list -= "A"
  // 複数の要素を一度に削除
  list --= List("C", "D")
  // インデックスを指定して要素を削除
  list.remove(1)

  // イミュータブルな List に変換
  val immutableList = list.toList

  println("list: " + list)
  println("immutableList: " + immutableList)

  // ListBuffer を空にする
  list.clear
  println("list: " + list)

  /**
   * ミュータブルな配列を使用する
   */
  println("-- ArrayBuffer --")

  // イミュータブルな Array を生成
  val arrayBuffer = ArrayBuffer("A", "B")
  "Z" +=: arrayBuffer
  arrayBuffer += "C"
  List("X", "Y") ++=: arrayBuffer
  arrayBuffer ++= List("D", "E")
  arrayBuffer(4) = "b"
  arrayBuffer -= "A"
  arrayBuffer.remove(2)

  var array = arrayBuffer.toArray

  println("arrayBuffer: " + arrayBuffer)
  println("array.toList: " + array.toList)

  /**
   * ミュータブルな Set を使用する
   */
  println("-- mutable.set --")

  import scala.collection.mutable.{ Set => MutableSet }

  // ミュータブルな Set を生成
  val set = MutableSet("A", "B")
  // += メソッドで要素を追加
  set += "C"
  // add メソッドで要素を追加
  set.add("D")
  // 複数の要素を一度に追加
  set ++= Set("E", "F")
  // -= メソッドで要素を削除
  set -= "A"
  // remove メソッドで要素を削除
  set.remove("B")
  // 複数の要素を一度に削除
  set --= Set("C", "D")

  println("set: " + set)

  // Set を空にする
  set.clear
  println("set: " + set)

  /**
   * ミュータブルな Map を使用する
   */
  println("-- mutable.Map --")

  import scala.collection.mutable.{ Map => MutableMap }

  // ミュータブルな Map を生成
  val map = MutableMap("key1" -> "value1")
  // put メソッドで要素を追加
  map.put("key2", "value2")
  // += メソッで要素を追加
  map += ("key3" -> "value3", "key4" -> "value4")
  // remove メソッドで要素を削除
  map.remove("key1")
  // -= メソッドで要素を削除
  map -= "key2"
  // --= メソッドで複数の要素を一度に削除
  map --= List("key3", "key4")

  // イミュータブルな Map に変換
  val immutableMap = map.toMap

  println("map: " + map)
  println("immutableMap: " + immutableMap)

}
