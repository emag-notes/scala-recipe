package flow

object BreaksSample extends App {

  import scala.util.control.Breaks

  // Breaks を使用するための準備
  val mybreaks = new Breaks

  // mybreaks の break メソッドと breakable メソッドをインポート
  import mybreaks.{break, breakable}

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i == 5)
        break
    }
    println("ここは実行されません")
  }

  // Breaks を使った continue の例
  val mycontinue = new Breaks

  import mycontinue.{break => continue, breakable => continuable}

  for (i <- 1 to 10) {
    continuable {
      if (i < 5) continue
      // ここは i が 5 以上のときのみ実行される
      println(i)
    }
  }
}
