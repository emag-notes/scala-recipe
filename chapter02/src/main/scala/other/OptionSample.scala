package other

object OptionSample extends App {

  // 値が存在する場合
  println("-- 値が存在する場合 --")
  val option1: Option[String] = Option("test")
  println(option1)

  // 値を取得(null の場合は NoSuchElementException が発生する)
  println("get=" + option1.get)
  // 値が空か
  println("isEmpty=" + option1.isEmpty)
  // 値が存在するか
  println("isDefined=" + option1.isDefined)

  // 値が存在しない場合は指定した値を返す
  println("getOrElse=" + option1.getOrElse("default"))


  // 値が存在しない場合
  println("-- 値が存在しない場合 --")
  val option2: Option[String] = Option(null)
  println(option2)

  // 値、もしくは null を取得
  println("orNull=" + option2.orNull)
  // 値が空か
  println("isEmpty=" + option2.isEmpty)
  // 値が存在するか
  println("isDefined=" + option2.isDefined)

  // 値が存在しない場合は指定した値を返す
  println("getOrElse=" + option2.getOrElse("default"))


  // パターンマッチによる Option 値の取得
  println("-- パターンマッチを使用して値を取得 --")
  val result2: String = option2 match {
    case Some(x) => x
    case None    => "default value"
  }
  println(result2)


  /**
   * Option の使用例(Map の場合)
   */
  println("-- Map#get メソッドは Option を返す --")
  val map: Map[String, String] = Map("key1" -> "value1", "key2" -> "value2")

  // Map の get メソッドは Option を返す
  val option: Option[String] = map.get("key1")
  // Option から値を取得
  val value = option.get
  println(value)


  /**
   * Option の値がある場合のみ処理する
   */
  println("-- foreach メソッドを使って処理 --")
  val option3: Option[String] = None
  // None なので処理は行われない
  option3.foreach { value: String => println(value)}

  val option4: Option[String] = Some("value")
  // Some なので処理が行われる
  option4.foreach { value: String => println(value)}

  val option5: Option[List[String]] = Some(List("value1", "value2", "value3"))
  // Some なので処理が行われる
  option5.foreach { value: List[String] => println(value)}
}
