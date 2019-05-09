package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_Intersection {

}

object O_Intersection {
  def apply: O_Intersection = new O_Intersection()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("intersection").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(5 to 20, 3)

    /**
      * intersection
      * 对于源数据集和其他数据集求交集，并去重，且无序返回。
      */
    rdd.intersection(rdd2).collect().foreach(elem => print(elem + " "))
  }
}
