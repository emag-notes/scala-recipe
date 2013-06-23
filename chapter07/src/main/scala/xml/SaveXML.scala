package xml

import scala.xml.XML

/**
 * XML を保存するサンプルです。
 */
object SaveXML extends App {

  val xml =
    <book>
        <title>Scala逆引きレシピ</title>
        <price>3200</price>
    </book>

  // 保存
  XML.save(
    "book.xml", // ファイル名
    xml,        // 保存対象の XML
    "UTF-8",    // エンコード
    true        // XML 宣言を付与する
  )

}
