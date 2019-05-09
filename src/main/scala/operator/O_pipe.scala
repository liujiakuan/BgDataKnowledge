package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_pipe {

}

object O_pipe {
  def apply: O_pipe = new O_pipe()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("pipe").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * pipe
      * 通过一个shell命令来对RDD各分区进行“管道化”。通过pipe变换将一些shell命令用于Spark中生成的新RDD
      */
    //glom()显示每个分区的元素
    pairRdd1.glom().collect().foreach(elem => print(elem + " "))
    //取每个分区第一个元素构成新的RDD
    pairRdd1.pipe("head -n 1").collect().foreach(elem => print(elem + " "))
  }
}
