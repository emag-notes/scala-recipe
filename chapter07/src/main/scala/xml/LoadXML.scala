package xml

import scala.xml.XML

/**
 * XML を読込むサンプルです。
 */
object LoadXML extends App {

  // 文字列から XML を読込む
  val strxml =
    """
      |<user>
      | <id>100</id>
      | <name>島本多可子</name>
      |</user>
    """.stripMargin

  val elem = XML.loadString(strxml)
  println(elem)

  // java.io.InputStream から XML を読込む
  val is = Thread.currentThread.getContextClassLoader.getResourceAsStream("user.xml")
  val elem2 = XML.load(is)
  println(elem2)

}
