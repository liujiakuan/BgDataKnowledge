package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_cogroup {

}

object O_cogroup {
  def apply: O_cogroup = new O_cogroup()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cogroup").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1,1,2,3,4,5,6,7,8,9,10), 3)
    val rdd2 = spark.sparkContext.parallelize(Seq(2,3,3,3,11,12,13,6,7), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))

    /**
      * cogroup
      * 合并两个RDD，生成一个新的RDD。实例中包含两个Iterable值，第一个表示RDD1中相同值(value值)，
      * 第二个表示RDD2中相同值（value值），
      * 这个操作需要通过partitioner进行重新分区，因此需要执行一次shuffle操作。
      * （若两个RDD在此之前进行过shuffle，则不需要）
      */
    pairRdd1.cogroup(pairRdd2, 5).collect().foreach(elem => print(elem + " "))
  }
}
