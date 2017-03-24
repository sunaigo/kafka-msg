package car.common.kafka

import java.util

/**
  * Created by sunyulong on 2017/3/24.
  */

//object KafkaClientPool {
//  val clientNum = 10
//  private[this] val pool = new util.Stack[KafkaClient]()
//  for (i <- 1 to clientNum) {
//    pool.push(new KafkaClient("10.1.12.108:9092,10.1.12.109:9092,10.1.12.110:9092", "obd3"))
//  }
//
//  def getKafkaClient:Option[KafkaClient]= {
//    if (pool.empty())
//      None
//    else
//      Some(pool.pop())
//  }
//
//  def returnKafkaClient(client: KafkaClient) = pool.push(client)
//
//}
