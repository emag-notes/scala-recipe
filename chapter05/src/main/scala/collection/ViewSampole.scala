package collection

object ViewSampole extends App {

  {
    // 0 から 5 までの要素を持つ List を生成
    val list = List(0, 1, 2, 3, 4, 5)

    // 要素を絞り込んだビューを生成
    val view = list.view(2, 5)

    println("view: " + view)
    println("view.mkString: " + view.mkString(","))
  }
  {
    // 0 から 5 までの要素を持つ List を生成
    val list = List(0, 1, 2, 3, 4, 5)

    // Range オブジェクトに map メソッドを適用するビューを作成
    val view = list.view.map { _ + 1 }.map { _ * 2 }

    println("view: " + view)
    println("view.mkString: " + view.mkString(","))

    val seq = view.force
    println("seq: " + seq)
  }
  {
    import scala.collection.mutable._

    val list = ListBuffer(0, 1, 2, 3, 4, 5)

    // ミュータブルなコレクションに対するビューを作成
    val view = list.view

    println("view.mkString: " + view.mkString(","))

    // 元のコレクションを変更するとビューにも反映される
    list(0) = 9
    println("view.mkString: " + view.mkString(","))
  }

}
