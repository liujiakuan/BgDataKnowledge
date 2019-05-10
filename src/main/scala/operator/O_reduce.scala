package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_reduce {

}

object O_reduce{
  def apply: O_reduce = new O_reduce()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("reduce").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * reduce
      * reduce将RDD中元素两两传递给输入函数，同时产生一个新值，
      * 新值与RDD中下一个元素再被传递给输入函数，直到最后只有一个值为止
      */
    println(pairRdd1.reduce((elem1, elem2) => (elem1._1 + elem2._1, elem1._2))._1)
    println(pairRdd1.reduce((elem1, elem2) => (elem1._1 + elem2._1, elem1._2))._2)
  }
}
