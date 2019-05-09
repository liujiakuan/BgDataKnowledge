package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_MapPartitionsWithIndex {

}

object O_MapPartitionsWithIndex {
  def apply: O_MapPartitionsWithIndex = new O_MapPartitionsWithIndex()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_MapPartitionsWithIndex").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 20, 3)

    /**
      * MapPartitionsWithIndex Operator
      * 与mapPartitions类似，但需要提供一个表示分区索引值的整型值作为参数，
      * 因此function必须是（int， Iterator<T>）=>Iterator<U>类型的
      */
    rdd.mapPartitionsWithIndex {
      (index, iter) => {
        val result = List[String]()
        var i = 0
        while (iter.hasNext) {
          i += iter.next()
        }
        result.::(index + "|" + i).iterator
      }
    }.collect().foreach(elem => print(elem + " "))
  }
}
