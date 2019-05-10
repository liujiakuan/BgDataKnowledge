package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_takeSample {

}

object O_takeSample {
  def apply: O_takeSample = new O_takeSample()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("takeSample").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))

    /**
      * takeSample（withReplacement， num， [seed]）
      * 对于一个数据集进行随机抽样，返回一个包含num个随机抽样元素的数组，
      * withReplacement表示是否有放回抽样，
      * 参数seed指定生成随机数的种子。
      *
      * 该方法仅在预期结果数组很小的情况下使用，因为所有数据都被加载到driver端的内存中
      */
    pairRdd1.takeSample(withReplacement = true, 4, 2).foreach(elem => print(elem + " "))
  }
}