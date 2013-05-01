package function

/**
 * カリー化のサンプルです。
 * カリー化とは、引数が複数ある関数(またはメソッド)を、
 * 1 つの引数を持つ関数のチェーンとして呼び出せるように変換することです。
 */
object CurryingSample extends App {

  /*
   * 関数のカリー化
   */
  println("-- 関数のカリー化 --")
  val greetfunc = (title: String) => (name: String) => title + name

  // すべての引数リストを適用
  println(greetfunc("Hello!")("Takako"))
  // 引数を順に適用
  val hello = greetfunc("Hello!") // 変数 hello は String => String 型の関数
  println(hello("Naoki"))


  /*
   * メソッドのカリーか
   */
  println("-- メソッドのカリー化 --")
  def greetdef(title: String)(name: String) = title + name

  // すべての引数リストを適用
  println(greetdef("Hello!")("Takako"))

  // 最初の引数を適用した greetdef メソッドを関数に変換
  def greet(f: String => String) = f("Takako")
  println(greet(greetdef("Hello!")))

  // カリー化されたメソッドを部分適用で関数に変換
  val hello2 = greetdef("Hello!")_
  println(hello2("Naoki"))

  /*
   * curried メソッドを使って関数をカリー化
   */
  println("-- curried メソッドを使って関数をカリー化 --")
  val greetfunc2 = (title: String, name: String) => title + name
  // 関数をカリー化
  val curryfunc = greetfunc2.curried

  println(curryfunc("Hello!")("Takako"))

  /*
   * curried メソッドを使ってメソッドをカリー化
   */
  println("-- curried メソッドを使ってメソッドをカリー化 --")
  def greetdef2(title: String, name: String) = title + name
  // メソッドをカリー化
  val currydef = (greetdef2 _).curried

  println(currydef("Hello!")("Naoki"))
}
