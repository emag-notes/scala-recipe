package function

/**
 * クロージャのサンプルです。
 * クロージャとは、関数の生成時に外部の変数を取り込んで動作する関数のこと。
 * 取り込む変数を「自由変数」と呼ぶ。
 */
object ClosureSample extends App {
  // 引数 Int の無名関数がクロージャ、自由変数は times
  def multi(times: Int) = (i: Int) => {
    i * times
  }

  /*
   * 自由変数「10」を取り込んでクロージャを生成
   * multi メソッドの呼び出しごとにクロージャが作成され、
   * そのときに渡された自由変数にアクセスします。
   */
  val tentimes = multi(10)
  println(tentimes(3))

  // 生成されたクロージャを直接呼び出し
  println(multi(100)(3))
}
