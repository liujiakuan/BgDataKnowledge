package grammar

class ApplyMethod {
  def apply(): Unit = {
    println("class apply")
  }
}

object ApplyMethod {
  def apply(): Unit = {
    println("object apply")
  }
}

object MainRun {
  def main(args: Array[String]): Unit = {
    val applyObj = new ApplyMethod
    //通过class new Object 调用class的apply方法
    applyObj()
    //没有new 对象，默认调用伴生对象的apply方法
    ApplyMethod()
  }
}
