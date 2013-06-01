package oop

import java.io.{FileOutputStream, OutputStream}
import scala.reflect.ClassTag

/**
 * 非変の型パラメータを指定したサンプルです。
 */
class Nonvariant[A] {
  private var a: A = _

  def head: A = a
  def put(arg: A) = a = arg
}

/**
 * 共変の型パラメータを指定したクラスのサンプルです。
 */
class Covariant[+A](a: A) {
  def head: A = a
}

/**
 * 反変の型パラメータを指定したクラスのサンプルです。
 */
class Contravariant[-A](a: A) {
  def put(arg: A) = {
    println(a)
    println(arg)
  }
}

/**
 * Generalized Type Constraints を使ったサンプルです。
 */
class GeneralizedTypeConstraints[A](param: A) {
  // 型パラメータが String の場合のみ呼び出し可能
  def print(implicit evidence: A =:= String) = println(param)

  // 型パラメータが OutputStream のサブクラスの場合のみ呼び出し可能
  def output(implicit evidence: A <:< OutputStream) = println(param)

  // 型パラメータが暗黙の型変換で Long に変換可能な場合のみ呼び出し可能
  def double(implicit evidence: A => Long) = param * 2
}

object GenericsSample extends App {
  /*
   * 変位指定のあるクラスのインスタンスを生成
   */
  println("=== 変位指定のあるクラスのインスタンスを生成 ===")
  // 非変
  println("-- 非変 --")
  val v1: Nonvariant[String] = new Nonvariant[String]
  v1.put("非変")
  println(v1.head)

  // 共変
  println("-- 共変 --")
  val v2: Covariant[AnyRef] = new Covariant[AnyRef](new Object)
  val v3: Covariant[AnyRef] = new Covariant[String]("共変")
  println(v2.head)
  println(v3.head)

  // 反変
  println("-- 反変 --")
  val v4: Contravariant[String] = new Contravariant[String]("反変")
  val v5: Contravariant[String] = new Contravariant[AnyRef](new Object)
  v4.put("Hello!")
  v5.put("Hello!")

  /*
   * メソッドの型パラメータに境界を指定
   */
  println("=== メソッドの型パラメータに境界を指定 ===")
  // 上限境界
  println("-- 上限境界 --")
  def store[A <: OutputStream](stream: A) = println("%s: 出力処理".format(stream))
  store[FileOutputStream](new FileOutputStream("ファイル名"))

  // 下限境界
  println("-- 下限境界 --")
  import scala.xml._
  def store2[A >: Node](node: A) = println("%s: 出力処理".format(node))
  store2[NodeSeq](<book>Scala逆引きレシピ</book>)

  // 可視境界(暗黙の型変換で変換される型のみ指定できる)
  println("-- 可視境界 --")
  def store3[A <% Long](num: A) = println("%s: 出力処理".format(num * 2))
  store3[Int](10)

  /*
   * Generalized Type Constraints
   */
  println("=== Generalized Type Constraints ===")
  val gtc1 = new GeneralizedTypeConstraints[String]("Hello!")
  gtc1.print
  val gtc2 = new GeneralizedTypeConstraints[FileOutputStream](new FileOutputStream("ファイル名"))
  gtc2.output
  val gtc3 = new GeneralizedTypeConstraints[Int](10)
  println(gtc3.double)

  /*
   * 型パラメータの情報を記録
   */
  println("=== 型パラメータの情報を記録 ===")
  def newarray[T: ClassTag](xs: T*): Array[T] = {
    val clazz = implicitly[ClassTag[T]].runtimeClass
    println(clazz)

    val array = new Array[T](xs.length)
    var i = 0
    for (x <- xs.iterator) {
      array(i) = x
      i += 1
    }
    array
  }
  println(newarray(1, 2).toList)
  println(newarray("Hello1", "Hello2").toList)
}