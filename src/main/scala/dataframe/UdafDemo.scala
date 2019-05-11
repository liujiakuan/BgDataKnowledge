package dataframe

import dataframe.util.MyUdaf
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class UdafDemo {

}

object UdafDemo {
  def apply: UdafDemo = new UdafDemo()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("udf").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val dfSeq = spark.createDataFrame(Seq(("ljk", 22), ("yky", 20), ("xxx", 18))) toDF("name", "age")
    dfSeq.createOrReplaceTempView("tableName")
    spark.udf.register("myUdaf", MyUdaf)
    spark.sql("select myUdaf(age) from tableName").show()
  }
}
