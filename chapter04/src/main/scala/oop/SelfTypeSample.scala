package oop

/* ---------- トレイトを使ったソースのモジュール化 ---------- */
trait Language {
  case class Java(name: String)
  case class ObjectiveC(name: String)
}

/**
 * 自分型アノテーションを使って、OS トレイトを利用する際は、
 * Language トレイトのミックスインを前提とするよう指定する。
 */
trait OS { self: Language =>
  object Android {
    val devlang = List(Java)
  }
}

/* ---------- コンポーネント間の依存関係を定義する ---------- */
trait UserDao {
  def byId(id: Long): String
}
trait UserDaoImpl extends UserDao {
  def byId(id: Long) = "ID: %d".format(id)
}
trait DivisionDao {
  def allData: List[String]
}
trait DivisionDaoImpl extends DivisionDao {
  def allData = List("Development", "Sales")
}

/**
 * 自分型アノテーションを使って、ソースコード上で依存関係を定義する。
 * UserDao トレイトと DivisionDao トレイトと依存関係にある。
 */
trait SampleLogic {
  self: UserDao with DivisionDao =>

  def show(id: Long) = {
    val user = byId(id)
    val all  = allData

    println(user)
    println(all)
  }
}

/**
 * OS トレイトをミックスインするトレイト
 */
trait SmartPhone extends Language with OS {
  println(Android.devlang)
}

object SelfTypeSample extends App {
  val phone = new SmartPhone {}

  // SampleLogic を利用する際に、Dao トレイトの実装をミックスインする
  val logic = new SampleLogic with UserDaoImpl with DivisionDaoImpl
  logic.show(100)
}
