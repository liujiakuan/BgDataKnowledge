package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_cartesian {

}

object O_cartesian {
  def apply: O_cartesian = new O_cartesian()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cartesian").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2), 3)
    val rdd2 = spark.sparkContext.parallelize(Seq(2, 3, 3), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))

    /**
      * cartesian
      * 笛卡尔乘积    该操作不会执行shuffle操作
      */
    pairRdd1.cartesian(pairRdd2).collect().foreach(elem => print(elem + " "))
  }
}
