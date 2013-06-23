package xml

/**
 * Scala のコード(変数や式)を含む XML リテラルのサンプルです。
 */
object ContainVariablesXML extends App {

  val book = new Book("Scala逆引きレシピ", 3200, Map(1 -> "竹添直樹", 2 -> "島本多可子"))

  val xml =
    <book>
      <title>{book.title}</title>
      <price>{book.price}</price>
      <authors>
        {
          book.authors.map { case (key, value) =>
            <!-- 波括弧の中にも XML リテラルを記述可能 -->
            <author id={key.toString}>{value}</author>
          }
        }
      </authors>
    </book>

  println(xml)
}

case class Book(title: String, price: Int, authors: Map[Int, String])
