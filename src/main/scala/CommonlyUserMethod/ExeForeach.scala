package CommonlyUserMethod

class ExeForeach {
}

object ExeForeach {
  def main(args: Array[String]): Unit = {
    def apply: ExeForeach = new ExeForeach()

    //foreach 和 map的区别。foreach迭代指定计算，返回Unit，Map返回指定类型的集合
    val seqValue = Seq(1, 2, 3, 4, 5)
    seqValue.foreach(elem => println(elem))
    seqValue.map(elem => (elem, 1))
  }
}
