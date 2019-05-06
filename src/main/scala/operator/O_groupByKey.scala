package operator

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class O_groupByKey {

}

object O_groupByKey {
  def apply: O_groupByKey = new O_groupByKey()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("intersection").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val rdd = spark.sparkContext.parallelize(1 to 10, 3)
    val rdd2 = spark.sparkContext.parallelize(5 to 20, 3)
    val pairRdd1 = rdd.map(elem => (elem, 1))
    val pairRdd2 = rdd2.map(elem => (elem, 2))

    /**
      * groupByKey
      * 在一个PairRDD或（k,v）RDD上调用，返回一个（k,Iterable<v>）。
      * 主要作用是将相同的所有的键值对分组到一个集合序列当中，其顺序是不确定的。
      * groupByKey是把所有的键值对集合都加载到内存中存储计算，若一个键对应值太多，则易导致内存溢出。
      */
    pairRdd1.union(pairRdd2).groupByKey().collect().foreach(elem => print(elem + " "))
  }
}
