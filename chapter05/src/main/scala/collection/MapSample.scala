package collection

/**
 * Map のサンプルです。
 */
object MapSample extends App {

  create()
  foreach()
  add()
  concat()
  remove()
  map()
  sort()

  /**
   * Map の生成方法のサンプルです。
   */
  def create(): Unit = {
    println("-- Map を生成する --")

    // 空の Map を作成
    val emptyMap: Map[Int, String] = Map()
    println(emptyMap)
    // 指定したキーと値を持つ Map を作成
    val map = Map("key1" -> "value1", "key2" -> "value2")
    println(map)

    // Option 型で値を取得
    val get1 = map.get("key1")
    val get2 = map.get("key2")
    val get3 = map.get("key3")

    println("get1:" + get1)
    println("get2:" + get2)
    println("get3:" + get3)

    // キーがない場合を値を指定して取得
    val getOrElse1 = map.getOrElse("key1", "")
    val getOrElse2 = map.getOrElse("key2", "")
    val getOrElse3 = map.getOrElse("key3", "")

    println("getOrElse1:" + getOrElse1)
    println("getOrElse2:" + getOrElse2)
    println("getOrElse3:" + getOrElse3)

    // 値を直接取得できる
    val value1 = map("key1")
    val value2 = map("key2")

    println("value1: " + value1)
    println("value2: " + value2)

    try {
      val value3 = map("key3")
    } catch {
      case e: Throwable => println(e.getMessage)
    }

    // Map にキーが含まれているかどうかを調べる
    val contains1 = map.contains("key1")
    val contains3 = map.contains("key3")

    println("contain1: " + contains1)
    println("contain3: " + contains3)

    val symbol1 = 'scala
    val symbol2 = Symbol("scala")

    println(symbol1 eq symbol2)

    val symbolMap = Map('name -> "Naoki Takezoe",
                  'mail -> "takezoe@gmail.com")

    println(symbolMap('name))
    println(symbolMap('mail))
  }

  /**
   * Map の要素を繰り返し処理するサンプルです。
   */
  def foreach(): Unit = {
    println("-- Map の要素を繰り返し処理する --")

    val map = Map("key1" -> "value1",
                  "key2" -> "value2")

    // for 文で Map の要素を繰り返し処理
    for((key, value) <- map)
      println(key + "=" + value)

    // foreach メソッドで Map の要素を繰り返し処理
    map.foreach { e =>
      println(e._1 + "=" + e._2)
    }

    // パターンマッチでキーと値を抽出
    map.foreach { case (key, value) =>
      println(key + "=" + value)
    }

    // キーを繰り返し処理
    map.keys.foreach { key =>
      println(key)
    }

    // 値を繰り返し処理
    map.values.foreach { value =>
      println(value)
    }
  }

  /**
   * Map に要素を追加するサンプルです。
   */
  def add(): Unit = {
    println("-- Map に要素を追加する --")

    val map = Map("key1" -> "value1",
                  "key2" -> "value2")

    val newMap = map + ("key3" -> "value3",
                        "key4" -> "vlaue4")

    println("newMap: " + newMap)
  }

  /**
   * Map を連結するサンプルです。
   */
  def concat(): Unit = {
    println("-- Map を連結する --")

    // Map と Map を連結
    val map1 = Map("key1" -> "value1") ++ Map("key2" -> "value2")
    println("map1: " + map1)

    // Map と List を連結
    val map2 = Map("key1" -> "value1") ++ List(("key2", "value2"))
    println("map2: " + map2)

    // List と Map を連結(左辺が Map 以外の場合は ++: メソッドを使用する)
    val map3 = List(("key1", "value1")) ++: Map("key2" -> "value2")
    println("map3: " + map3)
  }

  /**
   * Map の要素を削除するサンプルです。
   */
  def remove(): Unit = {
    println("-- Map の要素を削除する --")

    val map = Map(
        "key1" -> "value1",
        "key2" -> "value2",
        "key3" -> "value3",
        "key4" -> "value4"
    )

    // 指定したキーを削除した新しい Map を作成
    val removedMap1 = map - "key1"
    println("removedMap1: " + removedMap1)

    // 複数のキー(タプルで指定)を削除した新しい Map を作成
    val removedMap2 = map - ("key2", "key3")
    println("removedMap2: " + removedMap2)

    // 複数のキー(コレクションで指定)を削除した新しい Map を作成
    val removedMap3 = map -- List("key1", "key2")
    println("removedMap3: " + removedMap3)
    
    // 値が "1" で終わる要素以外を削除する
    val filteredmap1 = map.filter {
      case(key, value) => value.endsWith("1")
    }
    println("filteredMap1: " + filteredmap1)

    // 値が "1" で終わる要素を削除する
    val filteredmap2 = map.filterNot {
      case(key, value) => value.endsWith("1")
    }
    println("filteredMap2: " + filteredmap2)
  }

  /**
   * Map の要素を変換するサンプルです。
   */
  def map(): Unit = {
    println("-- Map の要素を変換する --")

    val books = Map(
        1 -> "Seasar2徹底入門",
        2 -> "現場で使えるJavaライブラリ",
        3 -> "Scala逆引きレシピ"
    )

    // 要素の値を変換した新しい Map を作成
    val result1 = books.map { case(key, value) =>
      (key, "「" + value + "」")
    }
    println("result1: " + result1)

    // 要素を別のオブジェクトに変換
    case class Book(id: Int, name: String)

    // Book を要素に持つ Iterable を作成
    val result2 = books.map { case(key, value) =>
      Book(key, value)
    }
    println("result2: " + result2)
  }

  /**
   * Map の要素をソートするサンプルです。
   */
  def sort(): Unit = {
    println("-- ソートされた Map を使う --")

    {
      val books = Map(
        2 -> "現場で使えるJavaライブラリ",
        1 -> "Seasar2徹底入門",
        3 -> "Scala逆引きレシピ"
      )

      // ソートされたキーの List
      val sortedKeys = books.keys.toList.sorted // => List(1, 2, 3)

      // キーの昇順で繰り返し処理
      sortedKeys.foreach { key =>
        println("%d: %s".format(key, books(key)))
      }
    }
    {
      import scala.collection.immutable.SortedMap

      val books = SortedMap(
        2 -> "現場で使えるJavaライブラリ",
        1 -> "Seasar2徹底入門",
        3 -> "Scala逆引きレシピ"
      )

      // キーの昇順で繰り返し処理
      books.foreach { case (key, value) =>
        println("%d: %s".format(key, value))
      }
    }
  }
}
