package collection

import scala.collection.mutable._

/**
 * ミュータブルなコレクションを同期化するサンプルです。
 */
object SynchronizedSample extends App {

  // スレッドセーフな ArrayBuffer
  val arrayBuffer = new ArrayBuffer[String] with SynchronizedBuffer[String]

  // スレッドセーフな Set
  val set = new HashSet[String] with SynchronizedSet[String]

  // スレッドセーフな Map
  val map = new HashMap[String, String] with SynchronizedMap[String, String]
}
