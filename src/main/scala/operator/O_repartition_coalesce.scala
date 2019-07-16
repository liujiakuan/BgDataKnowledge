package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_repartition_coalesce {

}

object O_repartition_coalesce {
  def apply: O_repartition_coalesce = new O_repartition_coalesce()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("repartition_coalesce").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * coalesce    重新分区，减少RDD中分区的数量到numPartitions
      *
      * repartition是coalesce接口中shuffle为true的简易实现，
      * 即Reshuffle RDD并随机分区，使各分区数据量尽可能平衡。
      * 若分区之后分区数远大于原分区数，则需要shuffle
      */

    println("RDD默认分区数：" + spark.sparkContext.defaultParallelism)
    println("pairRdd1分区数：" + pairRdd1.partitions.length)
    val reSize = pairRdd1.coalesce(2, shuffle = false).partitions.length
    println("pairRdd1 coalesce 重新分区后分区数：" + reSize)
    val reSize2 = pairRdd1.repartition(2).partitions.length
    println("pairRdd1 coalesce 重新分区后分区数：" + reSize2)
  }
}
