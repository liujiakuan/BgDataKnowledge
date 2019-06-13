package broadCast

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class BroadCastEXE {

}

object BroadCastEXE {
  def apply: BroadCastEXE = new BroadCastEXE()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("createDataFrame").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val dfSeq = spark.createDataFrame(Seq(("ljk", 22), ("yky", 20), ("xxx", 18))) toDF("name", "age")

    //创建广播变量，广播变量是把一份数据广播到各个计算结点上，在计算时减少一部分网络传输
    val broads = spark.sparkContext.broadcast(6)

    dfSeq.rdd.map(elem => elem.getAs[Int]("age") * broads.value).foreach(elem => println(elem))
  }
}
