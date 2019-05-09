package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_aggregate {

}

object O_aggregate{
  def apply: O_aggregate = new O_aggregate()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("aggregate").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    /**
      * aggregate
      * acc 表示默认值
      * number表示rdd的值
      */
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val (mul, sum, count) = spark.sparkContext.parallelize(list, 2).aggregate((1, 0, 0))(
      (acc, number) => (acc._1 * number, acc._2 + number, acc._3 + 1),
      (x, y) => (x._1 * y._1, x._2 + y._2, x._3 + y._3)
    )
    val result = (sum / count, mul)
    print(result)
  }
}
