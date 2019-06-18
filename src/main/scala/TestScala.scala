class TestScala {
  private val aa = ""

  def testClass(): Unit = {

  }
}

//伴生对象即Scala的单列对象，定义了伴生对象之后，在创建对象时候不用使用new方法
object TestScala {
  def apply: TestScala = new TestScala()

  def main(args: Array[String]): Unit = {
    TestTwo.func()
    this.funcScala()
  }

  def funcScala(): Unit = {
    println("testScala")
  }
}

object TestOne {
  def apply: TestScala = new TestScala()
}

object TestTwo {
  def func(): Unit = {
    println("testTwo")
  }
}
