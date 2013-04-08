package intro

object HelloWorldArgs {
  def main(args: Array[String]): Unit = {
    val name: String = args(0)
    println("Hello %s!".format(name))
  }
}
