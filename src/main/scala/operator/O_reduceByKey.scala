package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_reduceByKey {

}

object O_reduceByKey {
  def apply: O_reduceByKey = new O_reduceByKey()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("reduceByKey").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(5 to 20, 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))

    /**
      * reduceByKey
      * 与groupByKey类似，却有不同。如(a,1), (a,2), (b,1), (b,2)。
      * groupByKey产生中间结果为( (a,1), (a,2) ), ( (b,1), (b,2) )。
      * 而reduceByKey为(a,3), (b,3)。
      *
      * reduceByKey主要作用是聚合，groupByKey主要作用是分组。（function对于key值来进行聚合）
      */
    pairRdd1.union(pairRdd2).collect().foreach(elem => print(elem + " "))
    pairRdd1.union(pairRdd2).reduceByKey((v1, v2) => v1 + v2).collect().foreach(elem => print(elem + " "))
  }
}
