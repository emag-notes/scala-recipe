package xml

import scala.xml.Elem

/**
 * XML リテラルの要素をコレクションで取得するサンプルです。
 */
object CollectionXML extends App {

  val xml =
    <book>
      <title>Scala逆引きレシピ</title>
      <price>3200</price>
      <authors>
        <author>
          <id>1</id>
          <name>竹添直樹</name>
          <sex>M</sex>
        </author>
        <author>
          <id>2</id>
          <name>島本多可子</name>
          <sex>F</sex>
        </author>
      </authors>
    </book>

  // 2人の author を Seq 型で取得
  val authors = (xml \\ "author").theSeq

  authors.foreach { author =>
    // author 要素のすべての子要素を取得
    author.child.collect { case profile: Elem => profile
    } foreach println
  }
}
