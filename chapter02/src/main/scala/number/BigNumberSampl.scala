package number

object BigNumberSampl extends App {

  {
    println("-- Int と BigInt の違い --")

    // Int の場合
    val i1 = 100000
    val i2 = 100000
    println(i1 * i2)  // => 1410065408(桁あふれを起こしている)

    // BigInt の場合
    val b1 = BigInt(100000)
    val b2 = BigInt(100000)
    println(b1 * b2)  // => 10000000000(正しい値が計算できている)
  }

  {
    println("-- Double と BigDecimal の違い --")

    // Double の場合
    val d1 = 1.0
    val d2 = 0.1
    println(d1 + d2 + d2)

    val b1 = BigDecimal(1.0)  // => 1.2000000000000002(丸め誤差が発生している)
    val b2 = BigDecimal(0.1)  // => 1.2(正しい値が計算できている)
    println(b1 + b2 + b2)
  }

  {
    println("-- 文字列から生成 --")

    // 文字列から BigInt のインスタンスを生成
    val i = BigInt("9999999999")
    // 文字列から BigDecimal のインスタンスを生成
    val d = BigDecimal("99999.999999999999")

    println("BigInt: " + i)
    println("BigDecimal: " + d)
  }

}
