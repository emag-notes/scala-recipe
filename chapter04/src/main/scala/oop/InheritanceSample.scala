package oop

/**
 * クラスの継承、フィールドやメソッドのオーバーライドのサンプルです。
 */
class SuperClass {
  val id   = 1
  var key  = "key1"
  def name = "SuperClass"
}

class SUbClass extends SuperClass {
  // val をオーバーライドには override キーワードが必要
  override val id = 100

  // var のオーバーライドに override キーワードは不要
  key = "key100"

  // メソッドのオーバーライドには override キーワードが必要
  override def name = "SubClass: " + super.name
}
