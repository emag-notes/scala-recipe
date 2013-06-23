package xml

/**
 * XML を比較するサンプルです。
 */
object CompareXML extends App {

  // 皮革対象の XML
  val xml =
    <book>
      <title>Seasar2徹底入門</title>
      <author id="1">竹添直樹</author>
    </book>

  // 比較
  val other =
    <book>
        <title>Seasar2徹底入門</title>
    </book>

  // 要素や属性、値が異なると一致しない
  println(xml.strict_==(other))
  println(xml.strict_!=(other))

  // 検索結果と比較
  val same =
    <author id="1">竹添直樹</author>

  println((xml \ "author").strict_==(same))
  println((xml \ "author").strict_!=(same))
}
