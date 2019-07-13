package grammar

class ForYield {

}

object ForYield{
  def apply: ForYield = new ForYield()

  def main(args: Array[String]): Unit = {
    val list = for (
      i <- 1 to 5
      if i %2 ==1
    ) yield i
    list.foreach(println)
  }
}