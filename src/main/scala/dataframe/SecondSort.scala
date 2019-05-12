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
      * ascending，排序方式，默认为true升序
      * 方法一：继承Ordeed
      * 方法二：使用SortBy
      */
    //降序排序
    dfSeq.rdd.map(elem => (elem.getAs[Int](0), elem.getAs[Int](1))).sortBy(x => x, ascending = false).foreach(println)
    //按照第一列降序，第二列升序排列
    dfSeq.rdd.map(elem => (elem.getAs[Int](0), elem.getAs[Int](1))).sortBy(x => x._1, ascending = false).sortBy(x => x._2, ascending = true).foreach(println)
    //降序排列
    dfSeq.rdd.map(elem => {
      (new SecondeSortKey(elem.getAs[Int](0), elem.getAs[Int](1)), elem)
    }).sortByKey(ascending = false).foreach(elem => println(elem._2))
  }
}
