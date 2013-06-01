package oop

/**
 * 暗黙の引数を定義したメソッドのサンプルです。
 */
class TaxApply {
  // 暗黙の引数
  def tax(implicit tax: Tax) = tax.rate * 0.01

  // カリー化で暗黙の引数
  def calc(total: Int)(implicit vat: VAT, gst: GST) = {
    println("VAT: " + total * (vat.rate * 0.01))
    println("GST: " + total * (gst.rate * 0.01))
  }
}

/**
 * 暗黙の引数へ実際に渡す値を定義したオブジェクトです。
 */
object ImplicitValue {
  // val が暗黙の値
  implicit val vat = new VAT(5)
  implicit val gst = new GST(10)

  // オブジェクトが暗黙の値
  // トップレベルのオブジェクトとして定義できないので、ネストさせる必要がある。
  implicit object Customs extends Tax {
    def rate: Int = 5
  }

  // メソッドが暗黙の値
  implicit def anyFormatter[A] = new Formatter[A] {
    def format(value: A): String = value.toString
  }
  implicit def dateFormatter[A <: java.util.Date] = new Formatter[A] {
    def format(value: A): String =
      new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(value)
  }
}

class VAT(val rate: Int)
class GST(val rate: Int)
trait Tax {
  def rate: Int
}
trait Formatter[A] {
  def format(value: A): String
}

object ImplicitParameterSample extends App {
  // 暗黙の引数と実際に渡す値を同じスコープ上で扱えるようにする
  import ImplicitValue._

  // 暗黙の引数を利用して呼び出す
  val tax = new TaxApply
  tax.calc(1000)
  println(tax.tax)

  // 型パラメータを含む暗黙の引数を定義したメソッド
  def println[A](value: A)(implicit f: Formatter[A]): Unit =
    Predef.println(f.format(value))
  println("Hello World!")
  println(9999)
  println(new java.util.Date())
  println(new java.sql.Date(new java.util.Date().getTime))
}
