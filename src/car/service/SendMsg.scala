package car.service

import java.util

import akka.actor.{ActorSystem, Props}
import car.entity.Car
import car.kafka.KafkaClient

/**
  * Created by sunyulong on 2017/3/24.
  */
object SendMsg extends App{

  val carNum = 10
  val inertval = 1000
  val carList = new util.HashMap[Int,Car]()
  for (id <- 1 to carNum){
    carList.put(id,new Car(id))
  }

  val system = ActorSystem("CarSystem")

  val sender = system.actorOf(Props(new KafkaClient("10.1.12.108:9092,10.1.12.109:9092,10.1.12.110:9092", "obd3")),"car")
  sender ! ""
  while(carList.size() != 0){
    val it = carList.keySet().iterator()
    while(it.hasNext){
      val key = it.next()
      val car = carList.get(key)
      if(car.hasMsg)
        sender ! carList.get(key).nextMsg
      else
        carList.remove(key)
    }
    Thread.sleep(inertval)
  }

}
