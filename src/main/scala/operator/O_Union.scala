package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_Union {

}

object O_Union {
  def apply: O_Union = new O_Union()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("union").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(11 to 20, 3)

    /**
      * union
      * 对于源数据集和其他数据集求并集，不去重。
      * 多个RDD合并为一个RDD之后，分区是没有发生变化的，只是内容的求并集
      */
    rdd.union(rdd2).collect().foreach(elem => print(elem + " "))
  }
}
