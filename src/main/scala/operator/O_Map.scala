package operator

import java.util

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

class O_Map {

}

object O_Map {
  def apply: O_Map = new O_Map()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_map").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val schema = StructType(List(
      StructField("name", StringType, nullable = true),
      StructField("age", IntegerType, nullable = true)
    ))

    val valueList = new util.ArrayList[Row]()
    valueList.add(Row("ljk", 22))
    valueList.add(Row("yky", 20))
    valueList.add(Row("xxx", 18))

    val df = spark.createDataFrame(valueList, schema)

    df.show()

    /**
      * map operator
      * map的输入变换函数应用于RDD中所有元素，而mapPartitions应用于所有分区。
      * 区别于mapPartitions主要在于调用粒度不同。如parallelize（1 to 10， 3），
      * map函数执行10次，而mapPartitions函数执行3次
      */
    val rdd = df.rdd
    rdd.map(elem => {
      elem.get(1)
    }).foreach(println)
  }
}
