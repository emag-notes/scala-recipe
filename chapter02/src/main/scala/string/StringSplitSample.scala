package string

import scala.util.matching.Regex

object StringSplitSample extends App {

  // 指定したデリミタで分割
  {
    // 分割対象の文字列
    val source = "a,b,c"
    // , (カンマ)で分割
    val result: Array[String] = source.split(",")

    result.foreach { println(_) }
  }

  // 正規表現で分割
  {
    // 分割対象の文字列
    val source = "a,b\tc"
    // , (カンマ)もしくはタブで分割する正規表現
    val regex: Regex = "[,\t]".r
    // 正規表現で分割
    val result: Array[String] = regex.split(source)

    result.foreach { println(_) }
  }

}
