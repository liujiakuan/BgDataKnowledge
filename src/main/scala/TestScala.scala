class TestScala {

}

object TestScala {
  def apply: TestScala = new TestScala()

  def main(args: Array[String]): Unit = {
    TestTwo.func()
    this.func()
  }

  def func():Unit={
    println("testScala")
  }
}

object TestOne{
  def apply: TestScala = new TestScala()
}

object TestTwo{
  def func():Unit={
    println("testtwo")
  }
}
