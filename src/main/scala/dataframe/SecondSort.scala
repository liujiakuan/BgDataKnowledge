package dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class SecondSort {

}

class SecondeSortKey(val first: Int, val second: Int) extends Ordered[SecondeSortKey] with Serializable {
  override def compare(that: SecondeSortKey): Int = {
    if (this.first - that.first != 0) {
      this.first - that.first
    }
    else {
      this.second - that.second
    }
  }
}

object SecondSort {
  def apply: SecondSort = new SecondSort()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("udf").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val dfSeq = spark.createDataFrame(Seq(
      (1, 22), (2, 20), (3, 18),
      (3, 12), (2, 10), (1, 38),
      (4, 12), (6, 8), (5, 38),
      (5, 12), (4, 50), (2, 38)
    )) toDF("num_1", "num_2")

    /**
      * 二次排序：先更具一个条件进行排序，在该条件有序的基础上在根据另外的条件排序
      */
    //TODO 当前二次排序实现感觉有问题，提供一个思路，先根据指定列排序，在更具指定列分组后再排序  udf
    dfSeq.rdd.collect().map(elem => {
      (new SecondeSortKey(elem.getAs[Int](0), elem.getAs[Int](1)),elem)
    }).foreach(elem => print(elem + " "))
  }
}
