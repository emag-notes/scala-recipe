package other

import java.util.{Calendar, Date}

object ImplicitConversionSample extends App {

  // Date を Calendar に変換するメソッド
  implicit def date2calendar(date: Date): Calendar = {
    val cal = Calendar.getInstance()
    cal.setTime(date)
    cal
  }

  val date: Date = new Date()

  // Calendar 型の変数に Date オブジェクトを代入できる
  val cal: Calendar = date

  // Calendar を引数に取るメソッドを Date で呼び出しできる
  val (year, month, day) = getDate(date)

  def getDate(cal: Calendar): (Int, Int, Int) = (
    cal.get(Calendar.YEAR),
    cal.get(Calendar.MONTH) + 1,
    cal.get(Calendar.DAY_OF_MONTH)
  )

  // Date オブジェクトに対して Calendar のメソッドを呼び出せる
  val y = date.get(Calendar.YEAR)

  println((year, month, day))

  // 暗黙の型変換でクラスを拡張する
  object ListTailfill {
    // 暗黙の型変換メソッド
    implicit def listTailfill[A](list: List[A]) = new {
      // 末尾が指定したサイズに満たない場合、null で埋めた List を返すメソッド
      def tailfill(min: Int) =
        if(min <=  list.size) list.tail
        else list.tail ::: List.fill(min - list.size)(null)
    }
  }

  // 型変換用のメソッドをインポート
  import ListTailfill._

  val list = List("a", "b", "c")
  // 暗黙の型変換を行う
  println(list.tailfill(2))
  println(list.tailfill(4))

}
