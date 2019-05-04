package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_Filter {

}

object O_Filter {
  def apply: O_Filter = new O_Filter()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_Filter").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 20, 3)

    /**
      * Filter Operator
      */
    rdd.collect().foreach(elem => print(elem + " "))
    rdd.collect().filter(elem => elem % 2 == 0).foreach(elem => print(elem + " "))
  }
}
