package other {
  package hoge {
    package fuga {
      class PackageDefinitionSample2 {
      }
    }
  }
}

object PackageDefinitionSample2 extends App {
  import other.hoge.fuga.PackageDefinitionSample2
  println(classOf[PackageDefinitionSample2].getName)
}


