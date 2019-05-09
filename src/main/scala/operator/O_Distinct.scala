package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_Distinct {

}

object O_Distinct {
  def apply: O_Distinct = new O_Distinct()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("distinct").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 100, 3)

    /**
      * distinct
      * 返回一个在源数据集去重之后的新数据集，即去重，并局部无序而整体有序返回
      * numTasks并不跟分区有关系，而可以理解为一个数学概念中的“因子”。
      * 如果设置的numTasks能被数据集中元素整除，那么排序就按先无序的排因子，
      * 后无序排非因子的组合（即相当于局部无序）；如果设置的numTasks不能被数据集中所有元素整除，
      * 那么排序会按照去重之前RDD排序的顺序返回。
      *
      * 从这个numTasks=10中和numTasks=5中仔细观察可以确定这个“任务数”是将任务均分了，
      * 如5个任务数，那么一个任务集中元素个数为20个，
      * 从数据集中选择能被5整除的20个元素作为第一个数据集的结果
      * ，再选择能被5除之后余数为1的作为第二个数据集...以此类推，局部无序，而整体有序。
      *
      * 补充：Spark2.3及之后的官方文档中将原[numTasks]任务数参数改为了[numPartitions]分区数。
      */
    rdd.distinct().collect().foreach(elem => print(elem + " "))
    rdd.distinct(5).collect().foreach(elem => print(elem + " "))
    rdd.distinct(10).collect().foreach(elem => print(elem + " "))
  }
}
