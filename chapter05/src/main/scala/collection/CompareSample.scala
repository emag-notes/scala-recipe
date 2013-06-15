package collection

import scala.collection.immutable.{TreeMap, HashMap}

/**
 * コレクションの比較のサンプルです。
 */
object CompareSample extends App {

  // List を比較する
  val list1 = List("A", "B")
  val list2 = List("A", "B")
  val list3 = List("A", "C")

  val result1 = list1 == list2
  val result2 = list1 == list3

  println("result1: " + result1)
  println("result2: " + result2)

  // 要素は同じだがコレクションの首里が違う(Seq と Set)ので false
  val result3 = List("A", "B") == Set("A", "B")
  println("result3: " + result3)

  // 実装は異なるが同じ種類(Map)で要素も同じなので true
  val result4 =
    HashMap("key1" -> "value1", "key2" -> "value2") ==
    TreeMap("key1" -> "value1", "key2" -> "value2")
  println("result4: " + result4)

}
