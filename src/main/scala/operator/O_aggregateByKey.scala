package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_aggregateByKey {

}

object O_aggregateByKey{
  def apply: O_aggregateByKey = new O_aggregateByKey()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("aggregateByKey").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(5 to 20, 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))
  }
}
