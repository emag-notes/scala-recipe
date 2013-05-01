package flow

object IfSample extends App {

  /*
   * if 式から値を返す
   */
  val str = "Scala,Java"

  val list = if(str != null) {
    // 文字列 str が null でない場合、カンマで分割してリストとして返す
    str.split(",").toList
  } else {
    // 文字列 str が null の場合は空のリストを返す
    Nil
  }

  list.foreach {
    println _
  }

  /*
   * else ブロックが無いので戻り値は Any 型
   */
  val result1 = if(str != null) {
    // 戻り値は List[String](if に入らなかった場合の戻り値は Unit)
    str.split(",").toList
  }

  println(result1)


  /*
   * if ブロックと else if ブロックで値を返していないので戻り値は Any 型
   */
  var result2 = if (str == null) {
    // 戻り値は Unit
    println("null")
  } else if (str == "") {
    // 戻り値は Unit
    println("空文字列")
  } else {
    // 戻り値は List[String]
    str.split(",").toList
  }

  println(result2)

  /*
   * if 式を三項演算子風に使う
   */
  val result3 = if (str == null) "" else str

  println(result3)
}
