/**
  * Created by jhunter on 4/27/17.
  */
class Account(private var amount: Int = 0, private val uid: Int) {

  def getUniqueId() ={
    uid
  }

  def transfer(target: Account, n: Int) = {
    if (this.uid < target.uid) this.lockAndTransfer(target, n)
    else target.lockAndTransfer(this, -n)
  }

  private def lockAndTransfer(target: Account, n: Int) = {
    this.synchronized {
      target.synchronized {
        this.amount -= n
        target.amount += n
      }
    }
  }
}



