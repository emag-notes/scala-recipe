package string

object RawStringLiteralSample extends App {

  {
    var str = """ダブルクォート3つで囲むことで
      複数業の文字列リテラルを
      記述することができます。"""
    println(str)
  }

  {
    val str =
      """
        |SELECT
        | USER_ID,
        | USER_NAME
        |FROM USERS
        |ORDER BY USER_ID
      """.stripMargin
    println(str)
  }

}
