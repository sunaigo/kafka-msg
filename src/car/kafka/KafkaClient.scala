package car.kafka

import java.util.Properties
import akka.actor.Actor
import car.entity.Msg
import kafka.producer.{KeyedMessage, Producer, ProducerConfig}

class KafkaClient(broker: String, topic: String) extends Actor{

  private[this] val props = new Properties
  props.put("metadata.broker.list", broker)
  props.put("serializer.class", "kafka.serializer.StringEncoder")
  props.put("producer.type", "async")
  val producer = new Producer[String, String](new ProducerConfig(props))
  /*private[kafka] def send(any: Any) {
    val producer = new Producer[String, String](new ProducerConfig(props))
    any match {
      case msg: String => sendFun(msg, producer)
      case msgs: Array[String] => msgs.foreach(sendFun(_, producer))
      case msgs: List[String] => msgs.foreach(sendFun(_, producer))
      case _ => throw new RuntimeException("message type donot match")
    }
    producer.close
  }*/

  private[this] def send(msg: Some[Msg]) {
    val data = new KeyedMessage[String, String](topic, msg.toString)
    producer.send(data)
  }

  override def receive: Receive = {
    case msg:Some[Msg] => send(msg)
    case _ =>
  }
}