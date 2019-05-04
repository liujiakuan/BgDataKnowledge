package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_FlatMap {

}

object O_FlatMap {
  def apply: O_FlatMap = new O_FlatMap()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_Filter").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq("ljk", "yky"), 3)

    /**
      * FlatMap Operator
      * map是对RDD中元素逐一进行函数操作映射为另外一个RDD，而flatMap操作是将函数应用于RDD之中的每一个元素，
      * 将返回的迭代器的所有内容构成新的RDD。
      *
      * flatMap与map区别在于map为“映射”，而flatMap“先映射，后扁平化”，map对每一次（func）都产生一个元素，
      * 返回一个对象，而flatMap多一步就是将所有对象合并为一个对象。
      */
    rdd.collect().flatten.foreach(elem => print(elem + " "))
    rdd.flatMap(elem => elem.toCharArray).foreach(elem => print(elem + " "))
  }
}
