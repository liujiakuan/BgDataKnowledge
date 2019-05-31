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
    *
    * 隐式类:
    *         1.其所带的构造参数有且只能有一个
    *         2.隐式类必须被定义在类，伴生对象和包对象里
    *         3.隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
    *         4.作用域内不能有与之相同名称的标示符
    */
}

object TestImplicit {
  def apply: TestImplicit = new TestImplicit()


  def main(args: Array[String]): Unit = {
    //测试隐式参数如果没有定义implicit name，则如下调用会报错
    TestImplicit.person
    //测试隐式视图
    TestImplicit.printAge(22)

  }

  //隐式参数
  implicit var name: String = "ljk"

  def person(implicit name: String): Unit = {
    System.out.print(name)
  }

  //隐式视图
  implicit def stringToInt(ageString:Int) = ageString.toString
  def printAge(age: String): Unit = {
    System.out.print(age)
  }

}
