package collection

/**
 * 並列コレクションのサンプルです。
 */
object ParallelSample extends App {

  {
    val range = 1 to 10

    // 通常のコレクションを使用する場合
    val result1 = range.map { _ + 1 } reduceLeft { _ + _ }
    println("result1: " + result1)

    // 並列コレクションを使用する場合
    val result2 = range.par.map { _ + 1 } reduceLeft { _ + _ }
    println("result2: " + result2)
  }
  {
    import scala.collection.parallel.immutable._

    // ParSet を直接生成
    val parSet = ParSet(1, 2, 3)
    // ParSet を Set に変換
    val set = parSet.seq
    println("set: " + set)

    // ParMap を直接生成
    val parMap = ParMap("key1" -> "value1", "key2" -> "value2")
    // ParMap を Map に変換
    val map = parMap.seq
    println("map: " + map)
  }
}
