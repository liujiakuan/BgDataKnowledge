package CommonlyUserMethod

class ExeForeach {

}

object ExeForeach {
  def main(args: Array[String]): Unit = {
    def apply: ExeForeach = new ExeForeach()

    val seqValue = Seq(1, 2, 3, 4, 5)
    seqValue.foreach(elem => println(elem))
  }
}
