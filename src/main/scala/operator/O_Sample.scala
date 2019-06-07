package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_Sample {

}

object O_Sample {
  def apply: O_Sample = new O_Sample()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sample").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(("a", 1), ("b", 2), ("c", 3), ("d", 4),
      ("e", 5), ("f", 6), ("g", 7), ("h", 8), ("i", 9), ("j", 10), ("k", 11), ("l", 12)), 3)

    /**
      * sample
      * 采样操作，用于从样本中取出部分数据。
      * withReplacement是否放回，fraction采样比例，seed用于指定的随机数生成器的种子。
      * 是否放回抽样分true和false，fraction取样比例为(0, 1]。seed种子为整型实数。
      */
    rdd.sample(false, 0.8, 5)
      .collect()
      .foreach(elem => print(elem + " "))
  }
}
