package collection

/**
 * Stream のサンプルです。
 */
object StreamSample extends App {

  // ファクトリメソッドを使用して生成
  val stream1 = Stream("A", "B", "C")
  println("stream1: " + stream1)
  println("stream1(1): " + stream1(1))

  // #:: メソッドを使用して生成
  val stream2 = "A" #:: "B" #:: "C" #:: Stream.empty
  println("stream2: " + stream2)
  println("stream2(2): " + stream1(2))

  // 巨大な List を生成すると OutOfMemory が発生
//  val list = 0 to 大きい数 toList

  // Stream なら大丈夫
//  val stream = 0 to 大きい数 toStream

  /**
   * ResultSet を Stream でラップする
   */
  def fromResultSet(rs: java.sql.ResultSet): Stream[(Int, String)] = {
    rs.next match {
      case false => Stream.empty
      case true  => (rs.getInt("USER_ID"), rs.getString("USER_NAME")) #:: fromResultSet(rs)
    }
  }

}
