package other

object VariableSample extends App {

  var value1: String = "varで宣言した変数"
  value1 = "varで宣言した変数には再代入が可能"

  val value2: String = "valで宣言した変数"
  // 以下の行はコンパイルエラーになる
//  value2 = "valで宣言した変数に再代入するとコンパイルエラー"

}
