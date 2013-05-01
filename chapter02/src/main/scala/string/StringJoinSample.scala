package string

object StringJoinSample extends App {

  // +演算子で結合
  val str = "Hello" + " " + "World!"
  println(str)

  // StringBuilder で結合
  val sb = new StringBuilder
  for(i <- 0 to 10) {
    sb.append("i=%d\n".format(i))
  }
  println(sb)

}
