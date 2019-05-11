package dataframe.util

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, IntegerType, StructField, StructType}

class MyUdaf {

}

object MyUdaf extends UserDefinedAggregateFunction{
  // 聚合函数的输入数据结构
  override def inputSchema: StructType = StructType(StructField("inputValue",IntegerType) :: Nil)

  // 缓存区数据结构
  override def bufferSchema: StructType = StructType(StructField("bufferValue",IntegerType) :: Nil)

  // 聚合函数返回值数据结构
  override def dataType: DataType = IntegerType

  // 聚合函数是否是幂等的，即相同输入是否总是能得到相同输出
  override def deterministic: Boolean = true

  // 初始化缓冲区
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0
  }

  // 给聚合函数传入一条新数据进行处理
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getInt(0) + input.getInt(0)
  }

  // 合并聚合函数缓冲区
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getInt(0)+buffer2.getInt(0)
  }

  // 计算最终结果
  override def evaluate(buffer: Row): Any = {
    buffer.getInt(0)
  }
}
