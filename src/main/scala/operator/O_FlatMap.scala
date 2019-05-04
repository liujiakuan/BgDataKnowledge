package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_FlatMap {

}

object O_FlatMap {
  def apply: O_FlatMap = new O_FlatMap()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_Filter").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq("ljk", "yky"), 3)
    rdd.collect().flatten.foreach(elem => print(elem + " "))
    rdd.flatMap(elem => elem.toCharArray).foreach(elem => print(elem + " "))
  }
}
