package string

object StringEqualsSample extends App {

  val str1 = readLine("Please input string1: ")
  val str2 = readLine("Please input string2: ")

  // 値の比較
  val result1 = (str1 == str2)
  val result2 = (str1 eq str2)

  println("%s == %s: %s".format(str1, str2, result1))
  println("%s eq %s: %s".format(str1, str2, result2))

}
