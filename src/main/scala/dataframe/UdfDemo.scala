package dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

class UdfDemo {

}

object UdfDemo {
  def apply: UdfDemo = new UdfDemo()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("udf").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val dfSeq = spark.createDataFrame(Seq(("ljk", 22), ("yky", 20), ("xxx", 18))) toDF("name", "age")
    //def 定义方法
    //下面是函数定义，函数没有返回值，也可以说返回的就是方法体
    //对dataFrame某一列乘以2
    val func = (colName: Int) => colName * 2
    val myUdf = udf(func)
    dfSeq.withColumn("udfCol", myUdf(dfSeq("age"))).show()
  }
}
