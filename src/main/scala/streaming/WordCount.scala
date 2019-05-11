package streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.scalatest.time.Seconds

class WordCount {

}

object WordCount{
  def apply: WordCount = new WordCount()

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparkStreaming wordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf,Seconds(2))
    val lines = ssc.textFileStream("")
    val wordCount = lines.flatMap(_.split(" ")).map(elem => (elem,1)).reduceByKey(_ + _)
    wordCount.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
