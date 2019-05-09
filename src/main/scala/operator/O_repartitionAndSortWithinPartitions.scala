package operator

import org.apache.spark.{Partitioner, SparkConf}
import org.apache.spark.sql.SparkSession


class KeyBasePartitioner(partitions: Int) extends Partitioner {
  //分区数
  override def numPartitions: Int = partitions
  //该方法决定了你的数据被分到那个分区里面
  override def getPartition(key: Any): Int = {
    val k = key.asInstanceOf[String]
    Math.abs(k.hashCode() % numPartitions)
  }
}

class O_repartitionAndSortWithinPartitions {

}

object O_repartitionAndSortWithinPartitions {
  def apply: O_repartitionAndSortWithinPartitions = new O_repartitionAndSortWithinPartitions()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("repartition_coalesce").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * repartitionAndSortWithinPartitions
      * 根据partitioner对RDD进行分区，并且在每个结果分区中按key进行排序
      * 比使用repartition And sortByKey 效率高，
      * 这是由于它的排序是在shuffle过程中进行，一边shuffle，一边排序
      */

    pairRdd1.repartitionAndSortWithinPartitions(new KeyBasePartitioner(2))
  }
}

