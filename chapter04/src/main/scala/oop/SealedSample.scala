package oop

/**
 * シールドクラスのサンプルです。
 * sealed が付与されたクラスを継承できるのは、同一ソースファイル内のクラスだけ！
 */
sealed abstract class Message

// シールドクラスを継承したケースクラス
case class TextMessage()   extends  Message
case class ObjectMessage() extends Message
case class ByteMessage()   extends Message

object SealedSample extends App {
  /*
   * パターンマッチ
   * ByteMessage クラスに対応するパターンが不足しているので、
   * 以下の警告が出る。
   * ---------------------------------------------------
   * match may not be exhaustive.
   * It would fail on the following input: ByteMessage()
   * def message(m: Message) = m match {
   *                ^
   * ---------------------------------------------------
   */
  def message(m: Message) = m match {
    case TextMessage()   => println("TextMessage")
    case ObjectMessage() => println("ObjectMessage")
//    case ByteMessage()   => println("ByteMessage")
  }

  message(ObjectMessage())
}
