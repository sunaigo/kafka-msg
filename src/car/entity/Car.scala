package car.entity

/**
  * Created by sunyulong on 2017/3/24.
  */

class Car(id: Int) {

  private[this] val totalnum = util.Random.nextInt(100)
  private[this] var msgnum = totalnum
  private[this] var mtype: Int = 1
  private[this] var hasnext = true

  def nextMsg: Option[Msg] = {
    if (msgnum != totalnum) {
      mtype = 2
    }
    msgnum = msgnum - 1
    if (msgnum <= 0) {
      mtype = 3
      hasnext = false
      Some(Msg(id, totalnum - msgnum, mtype, System.currentTimeMillis(), util.Random.nextInt(100)))
    } else {
      Some(Msg(id, totalnum - msgnum, mtype, System.currentTimeMillis(), util.Random.nextInt(100)))
    }
  }

  def hasMsg: Boolean = hasnext

}

