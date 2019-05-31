package grammar.`implicit`

class TestImplicit {
  /**
    * 使用方式:
    * 1.将方法或变量标记为implicit
    * 2.将方法的参数列表标记为implicit
    * 3.将类标记为implicit
    *
    * Scala支持两种形式的隐式转换：
    * 隐式值：用于给方法提供参数
    * 隐式视图：用于类型间转换或使针对某类型的方法能调用成功
    */
}

object TestImplicit {
  def apply: TestImplicit = new TestImplicit()


  def main(args: Array[String]): Unit = {
    //如果没有定义implicit name，则如下调用会报错
    TestImplicit.person
  }

  //隐式参数
  implicit var name: String = "ljk"

  def person(implicit name: String): Unit = {
    System.out.print(name)
  }
}
