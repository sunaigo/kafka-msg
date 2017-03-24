package car.service

import java.util

import akka.actor.{ActorSystem, Props}
import car.common.kafka.KafkaClient
import car.entity.Car

/**
  * Created by sunyulong on 2017/3/24.
  */
class SendMsg(carNum:Int, inertval:Long) {
  val carList = new util.HashMap[Int,Car]()

  for (id <- 1 to carNum){
    carList.put(id,new Car(id))
  }

  val system = ActorSystem("CarSystem")
  val sender = system.actorOf(Props(new KafkaClient("10.1.12.108:9092,10.1.12.109:9092,10.1.12.110:9092", "obd3")),"car")
  while(carList.size() != 0){
    for(key <- carList.keySet()){
      val car = carList.get(key)
      if(car.hasMsg)
        sender ! carList.get(key).nextMsg
      else
        carList.remove(key)
    }
    Thread.sleep(inertval)
  }

}
