package string

object StringMatchSample extends App {

  // 郵便番号にマッチする正規表現
  val pattern = """^\d{3}-\d{4}+$"""

  val result1 = "244-0801".matches(pattern)
  println(result1)

  val result2 = "2440801".matches(pattern)
  println(result2)

}
