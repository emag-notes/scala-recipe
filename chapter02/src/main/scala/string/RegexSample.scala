package string

import scala.util.matching.Regex
import scala.util.matching.Regex.Match

object RegexSample extends App {

  /*
   * 正規表現にマッチした部分の取得
   */
  {
    println("-- 正規表現にマッチした部分の取得 --")

    // 3桁の数字にマッチする正規表現を作成
    val regex = """\d{3}""".r

    // Regex クラスのコンストラクタで生成することもできる
    val regex2 = new Regex("""\d{3}""")

    // 検索対象の文字列
    val source = "123 to 456"

    // マッチした部分を繰り返し処理
    regex.findAllIn(source).foreach {
      println(_)
    }

    // マッチした部分をリストで取得
    val list: List[String] = regex.findAllIn(source).toList
    list.foreach {
      println _
    }
  }

  /*
   * 正規表現のグループ化
   */
  {
    println("-- 正規表現のグループ化 --")

    // HTML タグにマッチする正規表現を作成
    val regex: Regex = """<a href="(.*?)">(.*?)</a>""".r

    // 検索対象の文字列
    val source =
      """
        |<a href="http://www.google.co.jp/">Google</a>
        |<a href="http://www.scala-lang.org/">Scala</a>
      """.stripMargin

    // 最初にマッチした部分のみ
    regex.findFirstMatchIn(source).foreach { m: Match =>
      println("matched: " + m.matched)  // マッチした文字列全体
      println("group0: "  + m.group(0))  // 0 番目は matched と同じ
      println("group1: "  + m.group(1))  // 1 番目のグループを取得
      println("group2: "  + m.group(2))  // 2 番目のグループを取得

      println("before0: " + m.before(0))
      println("after0: "  + m.after(0))
      println("before1: " + m.before(1))
      println("after1: "  + m.after(1))
      println("before2: " + m.before(2))
      println("after2: "  + m.after(2))
    }

    // マッチした部分を繰り返し処理
    regex.findAllIn(source).matchData.foreach { m: Match =>
      println("group0: "  + m.group(0))  // 0 番目は matched と同じ
      println("group1: "  + m.group(1))  // 1 番目のグループを取得
      println("group2: "  + m.group(2))  // 2 番目のグループを取得
    }
  }

  /*
   * 正規表現のグループ化(名前付きグループ)
   */
  {
    println("-- 正規表現のグループ化(名前付きグループ) --")

    // グループ名を指定して正規表現を作成
    val regex = new Regex("""<a href="(.*?)">(.*?)</a>""", "url", "label")

    // 検索対象の文字列
    val source =
      """
        |<a href="http://www.google.co.jp/">Google</a>
        |<a href="http://www.scala-lang.org/">Scala</a>
      """.stripMargin

    // マッチした部分を繰り返し処理
    regex.findAllIn(source).matchData.foreach { m: Match =>
      println("url  : " + m.group("url"))
      println("label: " + m.group("label"))
    }
  }

  /*
   * 正規表現による文字列の置換
   */
  {
    println("-- 正規表現による文字列の置換 --")

    // 3桁の数字にマッチする正規表現
    val regex = """\d{3}""".r

    // 置換対象の文字列
    val source = "123 to 456"

    // マッッチした部分を、マッチした文字列の長さ分の*で置換
    val result = regex.replaceAllIn(source, {
      m: Match => "*" * m.group(0).length
    })
    println(result)

    // String#replaceAll() メソッドでの置換処理
    val result2 = source.replaceAll("""\d{3}""", "***")
    println(result2)
  }

}