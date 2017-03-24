package car.entity

/**
  * Created by sunyulong on 2017/3/24.
  */
case class Msg(carId: Int, mid: Int, mtype: Int, time: Long, num: Int) {
  override def toString: String = carId + "," + mid + "," + mtype + "," + time + "," + num
}
