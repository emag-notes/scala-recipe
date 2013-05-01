package function

import scala.annotation.tailrec
import scala.util.control.TailCalls._

/**
 * 末尾再帰のサンプルです。
 */
object TailRecursiveSample extends App {
  /*
   * 末尾再帰でループ処理
   * Scala の末尾再帰に依る最適化は JVM の制約により制限されたものになっている。
   * 末尾再帰による最適化を期待する場合は、@tailrec アノテーションを付与するとよい。
   * 最適化できない場合、コンパイルエラーになる。
   */
  @tailrec
  def sum(total: Int, list: List[Int]): Int = {
    if(list.isEmpty) total
    else sum(total + list.head, list.tail)
  }

  println(sum(0, List(100, 10, 50)))


  /*
   * トランポリン: 複数の関数が順にお互いを呼び出し合って再帰すること
   * Scala ではトランポリンによる末尾再帰の最適かも可能
   */
  def plus(total: Int, list: List[Int]): TailRec[Int] = {
    if(list.isEmpty) done(total)
    else tailcall(minus(total + list.head, list.tail))
  }

  def minus(total: Int, list: List[Int]): TailRec[Int] = {
    if(list.isEmpty) done(total)
    else tailcall(plus(total - list.head, list.tail))
  }

  println(plus(0, List(100, 10, 50)).result)

}
