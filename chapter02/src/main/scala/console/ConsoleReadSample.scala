package console

object ConsoleReadSample extends App {

  // コンソールから1行入力
  val name = readLine("Please input your name: ")
  // 入力した値を使用してメッセージを出力
  println("Hello %s!".format(name))

  // 数値(Int)を入力
  print("Please input your age: ")
  val age = readInt()

  println("You are %d years old.".format(age))

  // YYYY/MM/DDという形式で入力
  print("Please input date(YYYY/MM/DD): ")
  val list: List[Any] = readf("{0}/{1}/{2}")

  println("year  : %s".format(list(0)))
  println("month : %s".format(list(1)))
  println("day   : %s".format(list(2)))

  // readf3で入力
  print("Please input date(YYYY/MM/DD): ")
  val (year: String, month: String, day: String) = readf3("{0}/{1}/{2}")

  println("year  : %s".format(year))
  println("month : %s".format(month))
  println("day   : %s".format(day))

}
