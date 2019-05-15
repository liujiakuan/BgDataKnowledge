package streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

class WordCount {

}

object WordCount{
  def apply: WordCount = new WordCount()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparkStreaming wordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf,Seconds(2))
    val path = System.getProperty("user.dir")+"\\src\\main\\scala\\streaming\\data.txt"
    val lines = ssc.textFileStream(path)
    val wordCount = lines.flatMap(_.split(" ")).map(elem => (elem,1)).reduceByKey(_ + _)
    wordCount.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
