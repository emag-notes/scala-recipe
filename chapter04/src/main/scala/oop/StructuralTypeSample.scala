package oop

/**
 * 構造的部分型のサンプルです。
 */
object StructuralTypeSample extends App {
  // 構造的部分型を使ったメソッド
  // {def close()} の部分が構造的部分型
  // 引数 res は close() メソッドを含む任意の方であれば良い
  def using[T <: {def close()}, E](res: T)(f: T => E) = try {
    f(res)
  } finally {
    res.close
  }

  val ds = new DummyDataSource

  using(ds.getConnection) { con =>
    using(con.preparedStatement("INSERT INTO ...")) { ps =>
      ps.executeUpdate
    }
  }

}

// モッククラス
class DummyDataSource {
  def getConnection = new DummyConnection
}
class DummyConnection {
  def preparedStatement(sql: String) = new DummyPreparedStatement(sql)
  def close() = println("Connection をクローズ")
}
class DummyPreparedStatement(sql: String) {
  def executeUpdate = 1
  def close() = println("PreparedStatement をクローズ")
}