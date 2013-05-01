package number

object MathSample extends App {

  import scala.math._

  val d = 1.5

  // 四捨五入
  println(round(d))
  // 切り捨て
  println(floor(d))
  // 切り上げ
  println(ceil(d))

  // 0 - 1 未満のランダムな Double 値を取得
  println(random)

  // 0 - n-1 のランダムな整数を返すメソッド
  def randomInt(n: Double): Int = floor(random * n).toInt

  // 0 - 9 のランダムな整数を取得
  println(randomInt(10))

}
