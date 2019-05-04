package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_MapPartitions {

}

object O_MapPartitions {
  def apply: O_MapPartitions = new O_MapPartitions()

  def functionTest(iterator: Iterator[Int]): Iterator[Int] = {
    val it = for (elem <- iterator) yield elem * 2
    it
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("operator_MapPartitions").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 20, 3)

    /**
      * mapPartitions operator
      * map的输入变换函数应用于RDD中所有元素，而mapPartitions应用于所有分区。区别于mapPartitions主要在于调用粒度不同。
      * 如parallelize（1 to 10， 3），map函数执行10次，而mapPartitions函数执行3次。
      * 由于单独运行于RDD的每个分区上（block），所以在一个类型为T的RDD上运行时，
      * （function）必须是Iterator<T> => Iterator<U>类型的方法（入参）。
      */
    rdd.mapPartitions(functionTest).collect().foreach(elem => print(elem + " "))
  }
}
