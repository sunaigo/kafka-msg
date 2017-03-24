package car.entity

/**
  * Created by sunyulong on 2017/3/24.
  */
case class Msg(carId: Int, mtype: Int, time: Long, num: Int) {
  override def toString: String = carId + "," + mtype + "," + time + num
}
