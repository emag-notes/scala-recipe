package oop

/**
 * Scala のトレイトのサンプルです。
 */
trait Executor {
  // 抽象フィールド
  val value: String
  // デフォルト(抽象フィールドを利用)
  lazy val defaultValue = "Prefix: " + value

  // 抽象メソッド
  def handle()
}

/**
 * Executor トレイトの抽象メソッド(handle)を拡張するトレイト
 * この DefaultExecutor トレイトをミックスインできるのは、
 * Executor トレイトをミックスインするクラスやインスタンスのみ
 */
trait DefaultExecutor extends Executor {
  // Executor#handle メソッドの実行前後にログを出力
  abstract override def handle() = {
    println("start")

    super.handle()

    println("end")
  }
}

/**
 * Executor トレイトをミックスインするクラス
 */
class OutputConsole extends Executor {
  // 抽象フィールドを実装
  val value = "handle execute"

  // 抽象メソッドを実装
  def handle() = println(value)
}

/**
 * 同じメソッド名を持つトレイトとクラス
 */
trait TraitPrint {
  def print = println("TraitPrint")
}
class ClassPrint {
  def print = println("ClassPrint")
}

object TraitSample extends App {
  // 拡張した handle メソッドを呼び出す
  val exe = new OutputConsole with DefaultExecutor
  exe.handle()

  // 継承元を指定してメソッドを呼び出す
  val print = new ClassPrint with TraitPrint {
    override def print = {
      super.print
      super[TraitPrint].print
      super[ClassPrint].print
    }
  }
  print.print

  // 抽象フィールを参照する defaultValue フィールドの値を取得
  val output = new OutputConsole
  println(output.defaultValue)
}
