package collection

/**
 * タプルのサンプルです。
 */
object TupleSample extends App {

  // 要素を2つ持つタプル
  val user1: (Int, String) = (1, "Naoki Takezoe")
  // Predef で定義されているファクトリメソッドを使用
  val user2: (Int, String) = Pair(2, "Takako Shimamoto")

  // 要素を3つ持つタプル
  val book1: (String, String, Int) = ("現場で使えるJavaライブラリ", "翔泳社", 3780)
  // Predef で定義されているファクトリメソッドを使用
  val book2: (String, String, Int) = Triple("Scala逆引きレシピ", "翔泳社", 3200)

  // タプルから値を取得
  val id = user1._1
  val name = user1._2

  println(id)
  println(name)

  // タプルから値を分割
  val (bookName, publisher, price) = book1
  println(bookName)
  println(publisher)
  println(price)

  // パターンマッチで値を抽出
  book2 match {
    case (bookName, publisher, price) => {
      println(bookName)
      println(publisher)
      println(price)
    }
  }
}



