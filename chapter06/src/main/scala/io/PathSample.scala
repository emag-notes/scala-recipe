package io

/**
 * Scala IO によるファイル操作のサンプルです。
 */
object PathSample extends App {

  path()
  create()
  delete()
  copy()
  listFiles()
  parentDir()
  attribute()
  accessMode()
  javaFile()
  implicitPath()
  roots()

    /**
   * Path を生成するサンプルです。
   */
  def path(): Unit = {
    println("-- Path のインスタンスの生成 --")

    import scalax.file.Path

    // ファイルの Path を生成
    val filePath = Path("hoge.txt")
    // ネストした Path を生成
    val dirPath = Path("foo", "bar")
    // Path を起点に新たな Path を生成
    val subDirPath = dirPath / Path("hoge")

    println("filePath: " + filePath)
    println("dirPath: " + dirPath)
    println("subDirPath: " + subDirPath)

    // パス区切り文字列を指定して Path を生成
    val path = Path("foo/bar", '/')
    println("path: " + path)
  }

  /**
   * ファイル、ディレクトリの作成のサンプルです。
   */
  def create(): Unit = {
    println("-- ファイル、ディレクトリの作成 --")

    import scalax.file.Path

    // ファイルを作成
    val filePath = Path("hoge.txt")
    filePath.createFile()

    // ディレクトリを作成
    val dirPath = Path("foo", "bar")
    dirPath.createDirectory()

    // ファイルを作成。ただし、親ディレクトリを作成しない。
    // また、すでにファイルが存在する場合は例外をスローしない
    val path = Path("foo", "bar", "hoge.txt")
    path.createFile(createParents = false, failIfExists = false)
  }

  /**
   * ファイル、ディレクトリの削除のサンプルです。
   */
  def delete(): Unit = {
    println("-- ファイル、ディレクトリの削除 --")

    import scalax.file.Path

    // ファイルを削除
    val filePath = Path("hoge.txt")
    filePath.delete()

    // ディレクトリを再帰的に削除
    val dirPath = Path("foo")
    dirPath.deleteRecursively()
  }

  /**
   * ファイル、ディレクトリのコピー/移動のサンプルです。
   */
  def copy(): Unit = {
    println("-- ファイル、ディレクトリの移動/コピー --")

    import scalax.file.Path

    val from = Path("foo.txt")
    val to   = Path("foo", "bar.txt")

    from.createFile()

    // foo.txt を foo/bar.txt にコピー
    from.copyTo(to)

    // すでに存在する場合は上書き
    from.copyTo(to, replaceExisting = true)
    to.delete()

    // 親ディレクトリを作成しない
    from.copyTo(to, createParents = false)
    Path("foo").deleteRecursively()

    // foo.txt を bar.txt に移動
    from.moveTo(to)

    // 既に存在する場合は上書き
    from.createFile()
    from.moveTo(to, replace = true)

    Path("foo").deleteRecursively()
  }

  /**
   * ディレクトリ内のファイル、ディレクトリの一覧を行うサンプルです。
   */
  def listFiles(): Unit = {
    println("-- ディレクトリ内のファイル、ディレクトリの一覧の取得 --")

    import scalax.file.Path
    import scalax.file.PathSet

    // カレントディレクトリの子要素を取得
    val children = Path(".").children()
    children.foreach { child =>
      println(child)
    }

    println("-- 特定の条件を満たすファイルのみ表示 --")

    val filtered = Path(".").children().filter { file =>
      file.isFile && file.name.endsWith(".txt")
    }
    filtered.foreach { child =>
      println(child)
    }
  }

  /**
   * 親ディレクトリを取得するサンプルです。
   */
  def parentDir(): Unit = {
    println("-- 親ディレクトリの取得 --")

    import scalax.file.Path

    // カレントディレクトリの絶対パスを取得
    val path = Path().toAbsolute
    println(path)
    // カレントディレクトリの親ディレクトリを取得
    val parent = path.toAbsolute.parent
    println(parent)

    parent match {
      case Some(x) => println(x.path)
      case None => println("parent directory does not exist.")
    }
  }

  /**
   * ファイル、ディレクトリの属性を調べるサンプルです。
   */
  def attribute(): Unit = {
    println("-- ファイル、ディレクトリの属性を調べる --")

    import scalax.file.Path

    def printAttributes(path: Path): Unit = {
      // ファイルの様々な属性を Boolean で取得可能
      println("ファイルかどうか: " + path.isFile)
      println("ディレクトリかどうか: " + path.isDirectory)
      println("隠しファイルかどうか: " + path.isHidden)
      println("シンボリックリンクかどうか: " + path.isSymlink)
      println("読み取り可能かどうか: " + path.canRead)
      println("書き込み可能かどうか: " + path.canWrite)
      println("実行可能かどうか: " + path.canExecute)
      println("存在するかどうか: " + path.exists)

      // 最終更新日時は Long で取得可能
      println("最終更新日時: " + new java.util.Date(path.lastModified))

      // ファイルサイズは Option[Long] で取得可能
      println("ファイルサイズ: " + path.size)
    }

    printAttributes(Path("."))
    printAttributes(Path("build.sbt"))
  }

  /**
   * ファイル、ディレクトリのアクセスモードを調べるサンプルです。
   */
  def accessMode(): Unit = {
    println("-- ファイル、ディレクトリのアクセスモード --")

    import scalax.file.Path
    import scalax.file.Path.AccessModes._

    val path = Path("readme.txt")

    // アクセスモードを表示
    println(path.access)

    // 書き込み不可能に変更
    path.access -= Write
    // 読み取り不可能に変更
    path.access -= Read
    // 実行可能に変更
    path.access += Execute

    println(path.access)

    // アクセスモードを文字列で変更(r=読み取り, w=書き込み, e=実行)
    path.access = "rw"
    println(path.access)
  }

  /**
   * Path と java.io.File の相互変換を行うサンプルです。
   */
  def javaFile(): Unit = {
    println("-- Path と java.io.File の相互変換 --")

    import scalax.file.Path
    import scalax.file.defaultfs.DefaultPath

    // java.io.File から Path を生成
    val path = Path(new java.io.File("hoge.txt"))
    println(path)

    // Path から java.io.File を取得
    val jfile = path match {
      case x: DefaultPath => x.jfile
    }
    println(jfile)
  }

  /**
   * 暗黙の型変換によって Path を生成するサンプルです。
   */
  def implicitPath(): Unit = {
    println("-- 暗黙の型変換を使用した Path の生成 --")

    import scalax.file.Path

    // implicit をインポート
    import scalax.file.ImplicitConversions.{ string2path, jfile2path }

    // 文字列を Path に変換
    val path1: Path = "foo/bar/hoge.txt"
    println(path1)

    // java.io.File を Path に変換
    val path2: Path = new java.io.File("hoge.txt")
    println(path2)
  }

  /**
   * ファイルシステムルートを取得するサンプルです。
   */
  def roots(): Unit = {
    println("-- ファイルシステムルートの取得 --")

    import scalax.file.Path
    import scalax.file.defaultfs.DefaultPath

    val roots: Set[DefaultPath] = Path.roots
    roots.foreach { path =>
      println(path)
    }
  }
}
