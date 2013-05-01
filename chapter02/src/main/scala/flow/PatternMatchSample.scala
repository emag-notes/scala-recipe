package flow

import scala.xml.{Node, Elem}

object PatternMatchSample extends App {

  /**
   * 基本的なパターンマッチのサンプル
   */
  {
    println("-- 基本的なパターンマッチのサンプル --")

    basicMatchSample(0)
    basicMatchSample(1)
  }

  /**
   * 基本的なパターンマッチのサンプル
   */
  def basicMatchSample(i: Int): Unit = {
    val Java:  Int = 0
    val Scala: Int = 1

    val lang: String = i match {
      case Java  => "Java"
      case Scala => "Scala"
      case _     => throw new IllegalArgumentException
    }

    println(lang)
  }

  /**
   * 型によるパターンマッチのサンプル
   */
  {
    println("-- 型によるパターンマッチのサンプル --")

    println(getLength("aaa"))
    println(getLength(List[String]("aaa", "bbb")))
    println(getLength(Array[String]("aaa", "bbb", "ccc")))
  }

  /**
   * オブジェクトのサイズを取得するメソッド
   */
  def getLength(value: AnyRef): Int =
    value match {
      case x: String      => x.length
      case x: Array[_]    => x.length
      case x: Iterable[_] => x.size
      case _              => throw new IllegalArgumentException
    }

  /**
   * ケースクラス
   */
  case class Employee(empId: Int, name: String)

  /**
   * ケースクラスに対するパターンマッチ
   */
  def caseClassMatchSample(emp: Employee) =
    emp match {
      case Employee(_, "Naoki") => {
        // name が "Naoki" の場合の処理
      }
      case Employee(1, _) => {
        // empId が 1 の場合の処理
      }
      case Employee(empId, name) => {
        // すべての Employee にマッチ(変数にバインド)
      }
    }

  case class Publisher(name: String, address: String, tel: String)
  case class Book(title: String, price: Int, author: String, publisher: Publisher)

  /**
   * ネストしたケースクラスに対するパターンマッチのサンプル
   */
  def nestedCaseClassMatchSample(book: Book) =
    book match {
      case Book(title, price, author, Publisher("翔泳社", _, _)) => {
        // publisher が翔泳社の場合の処理
      }
      case _ => {
        // その他の場合の処理
      }
    }

  /**
   * List に対するパターンマッチのサンプル
   */
  {
    println("-- List に対するパターンマッチのサンプル --")

    listMatchSample(List(1, 2, 3))
    listMatchSample(List(4, 5))
    listMatchSample(List(6, 7, 8))
    listMatchSample(List(1, 3, 5, 7))
    listMatchSample(List(2))
  }

  /**
   * List に対するパターンマッチ
   */
  def listMatchSample(list: List[Int]) =
    list match {
      case List(1, 2, 3) => {
        println("長さが 3 、要素の値が 1, 2, 3 のリスト")
      }
      case List(_, _) => {
        println("長さ 2 のリスト")
      }
      case List(a, b, c) => {
        // 長さ 3 のリスト(変数にバインド)
        println("長さ 3 のリスト(%s, %s, %s)".format(a, b, c))
      }
      case List(1, _*) => {
        println("先頭の要素が 1 で長さは任意のリスト")
      }
      case _ => {
        println("どの条件にもマッチしないリスト")
      }
    }

  /**
   * List を再帰的に処理するサンプル
   */
  {
    println("-- List を再帰的に処理するサンプル --")

    printElements(List(1, 2, 3, 4))
    printElements(List())
  }

  def printElements(list: List[Int]): Unit =
    list match {
      case x :: xs => {
        println(x)  // 先頭の要素を表示
        printElements(xs) // 先頭の要素以外の list で再帰呼び出し
      }
      case Nil => println("end")  // list が空になったら終了
    }

  /**
   * 配列に対するパターンマッチのサンプル
   */
  {
    println("-- 配列に対するパターンマッチのサンプル --")

    arrayMatchSample(Array(1, 2, 3))
    arrayMatchSample(Array(4, 5))
    arrayMatchSample(Array(6, 7, 8))
    arrayMatchSample(Array(1, 3 ,5 ,7))
    arrayMatchSample(Array(2))
  }

  /**
   * 配列に対するパターンマッチ
   */
  def arrayMatchSample(array: Array[Int]): Unit =
    array match {
      case Array(1, 2, 3) => {
        println("長さが 3 、要素が 1, 2, 3 の配列")
      }
      case Array(_, _) => {
        println("長さが 2 の配列")
      }
      case Array(a, b, c) => {
        // 長さが 3 の配列(変数にバインド)
        println("長さが 3 の配列 (%s, %s, %s)".format(a, b, c))
      }
      case Array(1, _*) => {
        println("先頭の要素が 1 で長さは任意のリスト")
      }
      case _ => {
        println("どの条件にもマッチしない場合")
      }
    }

  /**
   * タプルに対するパターンマッチのサンプル
   */
  {
    println("-- タプルに対するパターンマッチのサンプル --")

    tupleMatchSample((1, 1))
    tupleMatchSample((1, 2))
    tupleMatchSample((2, 3))
  }

  def tupleMatchSample(tuple: (Int, Int)) =
    // 2つの要素を持つタプルに対するマッチング
    tuple match {
      case (1, 2) => {
        println("値が 1, 2 だった場合")
      }
      case (1, _) => {
        println("1つめの値が 1 だった場合")
      }
      case (a, b) => {
        // 上記の条件にマッチしない場合(変数にバインド)
        println("上記の条件にマッチしない場合 (%s, %s)".format(a, b))
      }
    }

  /**
   * 正規表現によるパターンマッチのサンプル
   */
  {
    println("正規表現によるパターンマッチのサンプル")

    regexMatchSample("111-2222")
    regexMatchSample("333-4444")
    regexMatchSample("111-222")
  }

  def regexMatchSample(s: String): Unit = {
    val pattern = """(\d{3})-(\d{4})""".r
    s match {
      case pattern("111", "2222") => {
        println("111-2222の場合")
      }
      case pattern(a, b) => {
        println("パターンにマッチしました (%s-%s)".format(a, b))
      }
      case _ => {
        println("マッチしませんでした")
      }
    }
  }

  /**
   * XML に対するパターンマッチのサンプル
   */
  {
    println("-- XML に対するパターンマッチのサンプル --")

    xmlMatchSample(<book><title>Scala逆引きレシピ</title></book>)
    xmlMatchSample(<book><title>Scala逆引きレシピ</title><publisher>翔泳社</publisher></book>)

    println("- ネストした XML によるパターンマッチのサンプル - ")
    // これはマッチする
    println(xmlMatchSample2(<book><title>Scala逆引きレシピ</title></book>))

    // 構造が違うとマッチしない
    println(xmlMatchSample2(<book><title>Scala逆引きレシピ</title><price>3360</price></book>))

    // 空のテキストノードが混ざっているだけでもマッチしない
    println(xmlMatchSample2(
      <book>
        <title>Scala逆引きレシピ</title>
      </book>))

    println("- ネストした XML によるパターンマッチのサンプル(空白や改行を無視してマッチ) - ")
    println(xmlMatchSample3(<book><title>Scala逆引きレシピ</title></book>))
    println(xmlMatchSample3(<book><title>Scala逆引きレシピ</title><price>3360</price></book>))
    println(xmlMatchSample3(
      <book>
        <title>Scala逆引きレシピ</title>
      </book>))
  }

  def xmlMatchSample(e: Elem): Unit = {
    e match {
      // 単一の子ノードを変数にバインド
      case <book>{child}</book> => {  // child は scala.xml.Node
        println(child.text)
      }
      // 任意の数の子ノードを変数にバインド
      case <book>{children @ _*}</book> => {  // children は Seq[scala.xml.Node]
        children.foreach { child: Node =>
          // ...
          println(child)
        }
      }
      case _ => println("マッチしませんでした。")
    }
  }

  /**
   * ネストした XML によるパターンマッチのサンプルです。
   */
  def xmlMatchSample2(e: Elem): Option[String] =
    e match {
      case <book><title>{value}</title></book> => Some(value.text)
      case _ => None
    }

  /**
   * ネストした XML に空白や改行を無視してマッチさせるサンプル
   */
  def xmlMatchSample3(e: Elem): Option[String] =
    e match {
      case <book>{children @ _*}</book> => (
        // 子ノードの中から title 要素を取得
        for (title @ <title>{_*}</title> <- children) yield title.text
      ).headOption
      case _ => None
    }

  /**
   * パターンガードのサンプル
   */
  {
    println("パターンガードのサンプル")

    patternGuardSample((1, 2))
    patternGuardSample((1, 1))
  }

  def patternGuardSample(tupple: (Any, Any)) = {
    tupple match {
      case (x, y) if x == y => {
        // タプルの要素が同じ値だった場合の処理
        println("same!")
      }
      case _ => {
        // それ以外の場合の処理
        println("not same!")
      }
    }
  }

  /**
   * 関数の引数に対するパターンマッチのサンプル
   */
  {
    println("-- 関数の引数に対するパターンマッチのサンプル --")

    functionArgumentMatch()
  }

  def functionArgumentMatch(): Unit = {
    // 省略せずに記述した場合
    val func1: String => Unit = { _ match {
        case "Scala" => println("Scala")
        case _ => println("Scala以外")
      }
    }

    // match を省略した場合
    val func2: String => Unit = {
      case "Scala" => println("Scala")
      case _ => println("Scala以外")
    }

    func1("Scala")
    func1("java")

    func2("Scala")
    func2("Java")
  }
}
