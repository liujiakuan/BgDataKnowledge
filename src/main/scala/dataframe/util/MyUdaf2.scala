package dataframe.util

import org.apache.spark.sql.Encoder
import org.apache.spark.sql.expressions.Aggregator


class MyUdaf2 {

}

object MyUdaf2 extends Aggregator{
  override def zero: Nothing = ???

  override def reduce(b: Nothing, a: Any): Nothing = ???

  override def merge(b1: Nothing, b2: Nothing): Nothing = ???

  override def finish(reduction: Nothing): Nothing = ???

  override def bufferEncoder: Encoder[Nothing] = ???

  override def outputEncoder: Encoder[Nothing] = ???
}