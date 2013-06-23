package xml

/**
 * XML を検索するサンプルです。
 */
object SearchingXML extends App {

  // 検索対象の XML
  val xml =
    <book>
      <title>Scala逆引きレシピ</title>
      <price>3200</price>
      <authors>
        <author id="1">竹添直樹</author>
        <author id="2">島本多可子</author>
      </authors>
    </book>

  // \メソッドは子要素のみ検索対象
  println("-- \\ メソッド --")

  println("title: "  + (xml \ "title"))
  println("book: "   + (xml \ "book"))
  println("author: " + (xml \ "author"))

  // \\ メソッデャ全ての要素が検索対象
  println("-- \\\\メソッド --")

  println("title2: " + (xml \\ "title"))
  println("book: "   + (xml \\ "book"))
  println("author: " + (xml \\ "author"))

  // 1番目(0から開始)の author 要素を取得
  println("-- 1番目(0から開始)の author 要素 --")

  println("author1 :" + (xml \\ "author")(1))

  // 値に "Scala" を含む title 要素
  println("-- 値に \"Scala\" を含む title 要素 --")

//  val scala = (xml \ "title") { node =>
//      node.text.contains("Scala")
//  }


  // title要素の値を取得
  println("-- title要素の値を取得 --")

  println("title要素: " + (xml \ "title").text)

  // 0番目の author 要素から id 属性の値を取得
  println("-- 0番目の author 要素から id 属性の値を取得 --")

  println((xml \\ "author")(0).attribute("id"))
  println((xml \\ "author")(0) \ "@id")
}
