package operator

import java.util

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession, types}

class O_Map {

}

object O_Map {
  def apply: O_Map = new O_Map()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_map").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val schema = StructType(List(
      StructField("name", StringType, true),
      StructField("age", IntegerType, true)
    ))

    val valueList = new util.ArrayList[Row]()
    valueList.add(Row("ljk", 22))
    valueList.add(Row("yky", 20))
    valueList.add(Row("xxx", 18))

    val df = spark.createDataFrame(valueList, schema)

    df.show()
  }
}
