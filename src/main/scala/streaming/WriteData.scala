package streaming

import java.io.{File, PrintWriter}

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class WriteData {

}

object WriteData {
  def apply: WriteData = new WriteData()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparkStreaming wordCount").setMaster("local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val sc = spark.sparkContext
    val path = System.getProperty("user.dir") + "\\src\\main\\scala\\streaming\\data.txt"
    val writer = new PrintWriter(new File(path))
    writer.println("ljk yky aaa ccc")
    writer.println("ljk yky aaa bbb")
    writer.println("ljk yky aaa bbb")
    //    while(true){
    //      writer.println("ljk yky aaa bbb")
    //      Thread.sleep(2000)
    //      writer.println("ljk yky cc dd")
    //    }
    writer.close()
  }
}
