package streaming

import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

class WordCount {

}

object WordCount {
  def apply: WordCount = new WordCount()

  private val logger: Logger = Logger.getLogger(classOf[WordCount])

  def main(args: Array[String]): Unit = {
    logger.info("---------WordCount Streaming Start--------")
    val conf = new SparkConf().setAppName("sparkStreaming wordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(10))
    val path = System.getProperty("user.dir") + "\\src\\main\\scala\\streaming\\testData"
    val lines = ssc.textFileStream(path)
    val wordCount = lines.flatMap(_.split(" ")).map(elem => (elem, 1)).reduceByKey(_ + _)
    logger.info("---------WordCount--------" + wordCount.print(0))
    logger.info("---------WordCount--------" + wordCount.print(1))
    logger.info("---------WordCount--------" + wordCount.toString)
    wordCount.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
