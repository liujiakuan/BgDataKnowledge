package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_sortByKey {

}

object O_sortByKey {
  def apply: O_sortByKey = new O_sortByKey()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sortByKey").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * sortByKey
      * 基于pairRDD的，根据key值来进行排序。ascending升序，默认为true，即升序；
      * numPartitions分区数
      */
    pairRdd1.sortByKey(true, 5).collect().foreach(elem => print(elem + " "))
    pairRdd1.sortByKey(false, 5).collect().foreach(elem => print(elem + " "))
  }
}
