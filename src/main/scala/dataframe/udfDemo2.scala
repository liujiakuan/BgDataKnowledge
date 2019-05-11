package dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class udfDemo2 {

}

object udfDemo2{
  def apply: udfDemo2 = new udfDemo2()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("udf").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val dfSeq = spark.createDataFrame(Seq(("ljk", 22), ("yky", 20), ("xxx", 18))) toDF("name", "age")
    spark.udf.register("strLength",(str:String) => str.length)
    dfSeq.createOrReplaceTempView("sqlTable")
    spark.sqlContext.sql("select strLength(name) from sqlTable").show()
  }
}
