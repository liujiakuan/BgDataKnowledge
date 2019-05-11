package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_takeOrdered {

}

object O_takeOrdered {
  def apply: O_takeOrdered = new O_takeOrdered()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("takeOrdered").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * takeOrdered
      * 返回RDD中前n个元素，并按默认顺序排序（升序）或者按自定义比较器顺序排序
      */
    pairRdd1.takeOrdered(3).foreach(elem => print(elem + " "))
  }
}
