package collection

/**
 * List のサンプルです。
 */
object ListSample extends App {

  create()
  get()
  add()
  remove()
  concat()
  iterate()
  map()
  sort()
  mkString()
  slice()
  split()
  check()
  flat()
  reduce()
  zip()

  /**
   * List の生成方法のサンプルです。
   */
  def create(): Unit = {
    println("-- List の生成 --")

    // ファクトリメソッドを使用して文字列型のリストを生成
    val list1 = List("A", "B")
    println("list1: " + list1)

    // List の長さを取得
    val size = list1.size
    // List が空かどうかを調べる
    val isEmpty = list1.isEmpty
    // List が空でないかどうかを調べる
    val nonEmpty = list1.nonEmpty

    // インデックスを指定して要素を取得
    val name1 = list1(0)
    val name2 = list1(1)

    println("size=%d".format(size))
    println("isEmpty=%s".format(isEmpty))
    println("nonEmpty=%s".format(nonEmpty))
    println("name1=%s".format(name1))
    println("name2=%s".format(name2))

    // :: メソッドを使用して文字列型のリストを生成
    val list2 = "A" :: "B" :: Nil
    println("list2: " + list2)

    // :: メソッドでネストした List を生成
    val list3 = ("A" :: "B" :: Nil) :: ("C" :: "D" :: Nil) :: Nil
    println("list3: " + list3)

    // ::: メソッドで複数のリストを結合したリストを生成
    val list4 = List("A", "B") ::: List("C", "D")
    println("list4: " + list4)
  }

  /**
   * List の要素を取得するサンプルです。
   */
  def get(): Unit = {
    println("-- 要素の取得 --")

    val list: List[String] = List("A", "B", "C", "D")

    // 先頭の要素を取得
    val head = list.head
    println("head: " + head)

    // 先頭の要素を除いたリストを取得
    val tail = list.tail
    println("tail: " + tail)

    // 2番目の要素を取得
    val second = list.tail.head
    println("second: " + second)

    // 3番目の要素を取得
    val third = list.tail.tail.head
    println("third: " + third)

    // 最後の要素を取得
    val last1 = list.last
    val last2 = list.reverse.head
    println("last1: " + last1)
    println("last2: " + last2)
  }

  /**
   * List に要素を追加する(要素を追加した新しい List を生成する)サンプルです。
   */
  def add(): Unit = {
    println("-- 要素の追加 --")

    val list = List("A", "B")

    // 末尾に要素を追加した List を作成
    val newList1 = list :+ "C"
    println("newList1" + newList1)

    // 先頭に要素を追加した List を作成
    val newList2 = "C" +: list
    println("newList2" + newList2)

    // 末尾に要素を追加した List を作成
    val newList3 = list ::: "C" :: Nil
    println("newList3" + newList3)

    // 先頭に要素を追加した List を作成
    val newList4 = "C" :: list
    println("newList4" + newList4)
  }

  /**
   * List の要素を削除(要素をフィルタリングした新しい List を生成)するサンプルです。
   */
  def remove(): Unit = {
    println("-- 要素の削除 --")

    {
      val list = List("A", "B", "C")

      // "C" を削除した新しい List を作成
      val result1 = list.filter { _ != "C" }
      println("result1: " + result1)

      // 上記のコードと同じ
      val result2 = list.filterNot { _ == "C" }
      println("result2: " + result2)
    }

    {
      val list = List("A", "B", "C")

      // 削除対象の要素を格納した List
      val target = List("A", "B")

      // "A" と "B" を削除した新しい List を作成
      val result1 = list.filter { ! target.contains(_) }
      println("result1: " + result1)

      // 上記のコードと同じ
      val result2 = list.filterNot { target.contains(_) }
      println("result2: " + result2)
    }

    {
      val list = List("A", "B", "C")

      // filter メソッドで "C" を削除した List を生成してから map を適用
      val result1 = list.filter { _ != "C" } map { _.toLowerCase }
      println("result1: " + result1)

      // withFilter メソッドでは "C" を削除した中間状態の List は生成されない
      val result2 = list.withFilter { _ != "C" } map { _.toLowerCase }
      println("result2: " + result2)
    }
  }

  /**
   * List を連結するサンプルです。
   */
  def concat(): Unit = {
    println("-- List の連結 --")

    val list1 = List("A", "B")
    val list2 = List("C", "D")
    val array = Array("E", "F")

    // List 同士を連結
    val newList1 = list1 ++ list2
    println("newList1: " + newList1)
    // List と Array を連結
    val newList2 = list1 ++ array
    println("newList2: " + newList2)

    // 結合後のコレクションの方は Array
    val newArray1 = array ++ list1
    println("newArray1: " + newArray1)
    // 結合後のコレクションの方は List
    val newArray2 = array ++: list1
    println("newArray2: " + newArray2)

    // ::: メソッドを使用して List を連結
    val newList3 = list1 ::: list2
    println("newList3:" + newList3)
  }

  /**
   * List の要素を繰り返し処理するサンプルです。
   */
  def iterate(): Unit = {
    println("-- List の繰り返し処理 --")

    val list = List("A", "B")

    // for 文で処理
    for (e <- list)
      println(e)

    // foreach メソッドで処理
    list.foreach { e =>
      println(e)
    }

    // 要素のインデックスが必要な場合
    list.zipWithIndex.foreach { case(e: String, i: Int) =>
      println("%d: %s".format(i, e))
    }
  }

  /**
   * List の要素を変換した新しい List を生成するサンプルです。
   */
  def map(): Unit = {
    println("-- List の要素の変換 --")

    {
      val list = List("Java", "Scala", "Clojure")

      // 文字列の長さを格納した List を作成
      val newList = list.map { _.length }

      println("newList: " + newList)
    }

    {
      // 文字列のみ抽出
      val list1 = List(1, "A", 2, "B")
      val result1 = list1.collect { case e: String => e }
      println("result1: " + result1)

      // 3 以上の要素を 2 倍した List を作成
      val list2 = List(1, 2, 3, 4)
      val result2 = list2.collect { case i if i >= 3 => i * 2 }
      println("result2: " + result2)
    }
  }

  /**
   * List のソートのサンプルです。
   */
  def sort(): Unit = {
    println("-- List を並び替えたい --")

    val list1 = List(2, 1, 4, 3)

    // List を自然順序付けの昇順でソート
    val sorted1 = list1.sorted
    println("sorted1: " + sorted1)

    // 降順でソート
    val sorted2 = list1.sorted.reverse
    println("sorted2: " + sorted2)

    val list2 = List("Takako", "Koshigaya", "Naoki")

    // 文字列の長さでソート
    val sorted3 = list2.sortWith { (a, b) => a.length < b.length }
    println("sorted3: " + sorted3)

    // sortBy メソッドを使用してソート
    val sorted4 = list2.sortBy { _.length }
    println("sorted4: " + sorted4)

    // 自作のクラスをソート可能にする
    case class Book(id: Int, name: String) extends Ordered[Book] {
      def compare(that: Book): Int = {
        id.compare(that.id) // id の昇順でソートされる
      }
    }

    val books = List(
        Book(2, "現場で使える Java ライブラリ"),
        Book(1, "Seasar2 徹底入門"),
        Book(3, "Scala 逆引きレシピ")
    )
    println(books.sorted)
  }

  /**
   * List を文字列に変換するサンプルです。
   */
  def mkString(): Unit = {
    println("-- List を文字列にしたい --")

    val list = List("竹添直樹", "島本多加子")

    // toString メソッドで文字列に変換
    val str1 = list.toString
    println(str1)

    // mkString メソッドで文字列に変換(デリミタなしで連結)
    val str2 = list.mkString
    println(str2)

    // mkString メソッドで文字列に変換(デリミタのみ指定)
    val str3 = list.mkString(" ／ ")
    println(str3)

    // mkString メソッドで文字列に変換(プレフィックス、デリミタ、サフィックスを指定)
    val str4 = list.mkString("Scala逆引きレシピ ", " ／ ", " 著")
    println(str4)
  }

  /**
   * List の一部を切り出した List を作成したい
   */
  def slice(): Unit = {
    println("-- List の一部を切り出した List を作成したい --")

    val list = List(1, 2, 3, 4)

    // 先頭の要素を除いた List
    val tail = list.tail
    println("tail: " + tail)

    // 末尾の要素を除いた List
    val init = list.init
    println("init: " + init)

    // 指定したインデックス鵜(1番目の要素から3番目の手前の要素)の範囲を含む List
    val slice = list.slice(1, 3)
    println("slice: " + slice)

    // 先頭の2つの要素からなる List
    val take = list.take(2)
    println("take: " + take)

    // 先頭の2つの要素を除いた List
    val drop = list.drop(2)
    println("drop: " + drop)

    // 先頭から順に条件を満たす要素を切り出した List
    val takeWhile = list.takeWhile { _ <= 2 }
    println("takeWhile: " + takeWhile)

    // 先頭から順に条件を満たす要素を除いた List
    val dropWhile = list.dropWhile { _ <= 2 }
    println("dropWhile: " + dropWhile)
  }

  /**
   * List を分割するサンプルです。
   */
  def split(): Unit = {
    println("-- List を分割したい --")

    val list = List(1, 2, 3, 4, 1)

    // 指定したインデックスで List 前後に分割する
    val (split1, split2) = list.splitAt(2)
    println("split1: " + split1)
    println("split2: " + split2)

    // 指定した条件を満たさない最初の要素の手前で分割
    val (span1, span2) = list.span { _ <= 2 }
    println("span1: " + span1)
    println("span2: " + span2)

    // 指定した条件を満たす要素と満たさない要素に仕分け
    val (partition1, partition2) = list.partition { _ <= 2 }
    println("partition1: " + partition1)
    println("partition2: " + partition2)

    // List の要素を指定した変換関数の結果でグルーピングした Map を作成
    val groupBy = list.groupBy { _ % 3 }
    println("groupBy: " + groupBy)
  }

  /**
   * List の要素が条件を満たすか調べるサンプルです。
   */
  def check(): Unit = {
    println("-- List の要素が条件を満たすか調べたい --")

    val list = List("Java", "Scala", "Clojure")

    // List に "Scala" が含まれているかどうかを調べる
    val contains = list.contains("Scala")
    println("contains: " + contains)

    // List に "J" で始まる文字列が含まれているかどうかを調べる
    val exists = list.exists { _.startsWith("J") }
    println("exists: " + exists)

    // List の全ての要素の長さが 4 以上かどうかを調べる
    val forall = list.forall { _.length >= 4 }
    println("forall: " + forall)
  }

  /**
   * ネストした List をフラットにするサンプルです。
   */
  def flat(): Unit = {
    println("-- flatten / flatMap のサンプル --")

    {
      val list = List(List(1, 2), List(3, 4))

      // flatten でネストした要素をフラットにする
      val result = list.flatten
      println("list.flatten: " + result)
    }
    {
      // List に Option がネストしている場合
      val list = List(Some(1), Some(2), None)

      // flatten で Option の値を取り出した List を取得する
      val result = list.flatten
      println("list.flatten: " + result)
    }
    {
      val list = List(1, 2, 3)

      // map 処理するとネストした List になる
      val map = list.map {
        e => List(e, e * 2)
      }
      println("map: " + map)

      // flatMap で map 処理を行ってからネストした要素をフラットにする
      // 中間の List を作成しないため、map と flatten を組み合わせるより処理効率が良い
      val result1 = list.flatMap {
        e => List(e, e * 2)
      }
      println("result1: " + result1)

      // 上記のコードと同じ結果になる
      val result2 = list.map {
        e => List(e, e * 2)
      }.flatten
      println("result2: " + result2)
    }
  }

  /**
   * 集計処理(reduce/fold)のサンプルです。
   */
  def reduce(): Unit = {
    println("-- reduce / fold のサンプル --")

    val list = List(1, 2, 3, 4, 5)

    // ((((1 + 2) + 3) + 4) + 5) という計算が行われる
    val result1 = list.reduceLeft {
      // a は前の要素までの計算結果、b は処理対象の要素(この関数の戻り値が次の a になる)
      (a, b) => a + b
    }
    println("result1: " + result1)

    // (1 + (2 + (3 + (4 + 5)))) という計算が行われる
    val result2 = list.reduceRight {
      // a は処理対象の要素、b は前の要素までの集計結果(この関数の戻り値がが次の b になる)
      (a, b) => a + b
    }
    println("result2: " + result2)

    // (((((0 + 1) + 2) + 3) + 4) + 5) という計算が行われる
    val result3 = list.foldLeft(0) {
      (a, b) => a + b
    }
    println("result3: " + result3)

    // (1 + (2 + (3 + (4 + (5 + 0))))) という計算が行われる
    val result4 = list.foldRight(0) {
      (a, b) => a + b
    }
    println("result4: " + result4)

    // foldLeft
    val result5 = (0 /: list) { _ + _ }
    println("result5: " + result5)

    // foldRight
    val result6 = (list :\ 0) { _ + _ }
    println("result6: " + result6)
  }

  /**
   * List の要素をマージ・案マージする(zip / unzip)サンプルです。
   */
  def zip(): Unit = {
    println("-- zip / unzip のサンプル --")

    val list1 = List(1, 2)
    val list2 = List("A", "B")

    // 2 つの List をマージ
    val list3 = list1.zip(list2)
    println("list3: " + list3)

    // タプルを要素として持つ List を分解
    val (list4, list5) = list3.unzip
    println("list4: " + list4)
    println("list5: " + list5)
  }

}
