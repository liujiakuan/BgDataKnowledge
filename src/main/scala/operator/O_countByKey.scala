package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_countByKey {

}

object O_countByKey {
  def apply: O_countByKey = new O_countByKey()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("countByKey").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * countByKey
      * 统计RDD[K,V]中每个K的数量，返回具有每个key的计数的（k，int）pairs的hashMap
      */
    pairRdd1.countByKey().foreach(elem => print(elem + " "))
  }
}
