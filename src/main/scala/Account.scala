/**
  * Created by jhunter on 4/27/17.
  */
class Account(private var amount: Int = 0) {
  def transfer(target: Account, n: Int) = {
    this.synchronized {
      target.synchronized {
        this.amount -= n
        this.amount += n
      }

    }
  }
}



