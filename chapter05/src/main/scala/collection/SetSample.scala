package collection

/**
 * Set のサンプルです。
 */
object SetSample extends App {

  /*
   * Set の基本的な使用方法
   */
  {
    // Set を生成
    val set = Set("A", "B", "C")

    // 要素が含まれているかの確認
    if (set.contains("A")) {
      println("Aが含まれています。")
    }

    // 要素を繰り返し処理
    set.foreach { println _ }

    // 世素を変換
    val result = set.map { _.length }
    println("result: " + result)

    // 要素を追加した新しい Set を生成
    val set2 = set + "D"
    println("set2: " + set2)
    // 複数の要素を一度に追加
    val set3 = set ++ Set("E", "F")
    println("set3: " + set3)

    // 要素を削除した新しい Set を生成
    val set4 = set - "A"
    println("set4: " + set4)
    // 複数の要素を一度に削除
    val set5 = set -- Set("B", "C")
    println("set5: " + set5)

    // 要素をフィルタリング("B"以外を抽出)
    val set6 = set.filter { s => s != "B" }
    println("set6: " + set6)
  }

  /*
   * Set の論理演算
   */
  {
    val set1 = Set(1, 2, 3)
    val set2 = Set(2, 3, 4)

    // 積集合(set1 と set2 の両方に含まれている要素からなる Set)
    println("set1 & set2: " + (set1 & set2))

    // 和集合(set1 と set2 のいずれかに含まれている要素からなる Set)
    println("set1 | set2: " + (set1 | set2))

    // 差集合(set1 の要素のうち set2 に含まれていない要素からなる Set)
    println("set1 &~ set2: " + (set1 &~ set2))
  }

  /*
   * ソートされた Set を使用する
   */
  {
    import scala.collection.immutable.SortedSet

    // ソート済みの Set を生成
    val sortedSet = SortedSet(2, 4, 3, 1)
    // 1, 2, 3, 4 の順で表示される
    sortedSet.foreach { println _ }
  }

}
