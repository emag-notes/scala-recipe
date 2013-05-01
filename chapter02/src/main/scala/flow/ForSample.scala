package flow

object ForSample extends App {

  /*
   * 指定した回数のループ処理
   */
  {
    println("-- 指定した回数のループ処理 --")

    // 1 から 10 までの範囲を繰り返し処理
    for (i <- 1 to 10) {
      println(i)
    }

    // 2 ずつインクリメントしながら 1 から 10 までの範囲を繰り返し処理
    for (i <- 1 to (10, 2)) {
      println(i)
    }

    // 1 から 10 までの範囲を表す Range を生成
    val range = Range(1, 10)

    for (i <- range)
      println(i)

    // List の繰り返し処理
    val list = List("A", "B", "C")

    for (e <- list)
      println(e)
  }

  /*
   * for ループでのフィルタリング
   */
  {
    println("-- for ループでのフィルタリング --")

    val list = List("Java", "Scala", "Clojure")

    for (lang <- list if ! lang.startsWith("J"))
      println(lang)

    // 複数の条件を指定する
    println("- 複数の条件を指定 -")
    for (lang <- list
          if ! lang.startsWith("J")
          if ! lang.startsWith("C"))
      println(lang)

    // このコードは上記の例と同じ意味
    for (lang <- list
          if ! lang.startsWith("J") && ! lang.startsWith("C"))
      println(lang)
  }

  /*
   * for ループから値を返す
   */
  {
    println("-- for ループから新しいコレクションを作成する --")

    val list = List("Java", "Scala", "Clojure")

    // 先頭が J 以外の要素を抽出
    val result = for(lang <- list if ! lang.startsWith("J")) yield lang

    result.foreach {
      println _
    }

    // 要素を加工したコレクションを作成
    println("- 要素を加工したコレクションを作成 -")
    val result2 = for(lang <- list) yield lang.toUpperCase

    result2.foreach {
      println _
    }
  }

  /*
   * for ループを入れ子にする
   */
  {
    println("-- for ループを入れ子にする --")

    // 入れ子になったループ
    for (x <- 1 to 10) {
      for (y <- 1 to 10) {
        println("x=%d, y=%d".format(x, y))
      }
    }

    // 上記のループはこのように書ける
    for (x <- 1 to 10; y <- 1 to 10) {
      println("x=%d, y=%d".format(x, y))
    }

    // 波括弧 { } を使用すると ; を省略できる
    for { x <- 1 to 10
          y <- 1 to 10 }
      println("x=%d, y=%d".format(x, y))

    // 入れ子のリスト
    val nestedList: List[List[String]] = List(
      List("Java", "C#", "Scala"),
      List("PHP", "Perl", "JavaScript"))

    // 入れ子のリストを for ループで処理する
    for (row <- nestedList; item <- row if item.startsWith("Java"))
      println(item)
  }

}
