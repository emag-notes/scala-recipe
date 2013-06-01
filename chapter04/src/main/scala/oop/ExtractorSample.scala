package oop

/**
 * コンパニオンオブジェクトから生成されるクラスです。
 */
class Book private
  (val title: String, val author: String, val pulisher: String, val price: Int)

/**
 * Book のコンパニオンオブジェクト
 */
object Book {
  // ファクトリメソッド
  def apply(title: String, author: String, publisher: String, price: Int): Book =
    new Book(title, author, publisher, price)

  // 抽出メソッド
  def unapply(book: Book): Option[(String, String, String, Int)] =
    Some(book.title, book.author, book.pulisher, book.price)

}

object ExtractorSample extends App {
  // ファクトリで Book クラスのインスタンス生成
  val book = Book("Seasar2徹底入門", "竹添直樹", "翔泳社", 3990)

  // 抽出子で Book クラスのインスタンスから情報を抽出
  val Book(title, author, publisher, price) = book

  println("タイトル:" + title)
  println("著者:" + author)
  println("出版社:" + publisher)
  println("価格:" + price)
}
