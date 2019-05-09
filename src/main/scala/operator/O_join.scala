package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_join {

}

object O_join {
  def apply: O_join = new O_join()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("join").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(5 to 20, 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))

    /**
      * join
      * 加入一个RDD，在一个（k，v）和（k，w）类型的加入一个RDD上调用，返回一个（k，（v，w））的加入一个RDD
      */
    pairRdd1.join(pairRdd2, 2).collect().foreach(elem => print(elem + " "))
  }
}
