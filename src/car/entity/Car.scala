package car.entity

/**
  * Created by sunyulong on 2017/3/24.
  */

class Car(id: Int) {

  private[this] val totalnum = util.Random.nextInt(100)
  private[this] var msgnum = totalnum
  private[this] var mtype: Int = 2

  def nextMsg: Option[Msg] = {
    if (totalnum == msgnum) mtype = 1
    if (msgnum == 0) mtype = 3
    msgnum = msgnum - 1
    if (msgnum < 0)
      None
    else
      Some(Msg(id, mtype, System.currentTimeMillis(), util.Random.nextInt(100)))
  }

  def hasMsg: Boolean ={
    if(msgnum < 0) false
    else true
  }

}

