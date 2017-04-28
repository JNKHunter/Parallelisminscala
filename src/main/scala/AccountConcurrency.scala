/**
  * Created by jhunter on 4/27/17.
  */
object AccountConcurrency {

  def main(args: Array[String]): Unit = {
    val a1 = new Account(500000, 1)
    val a2 = new Account(700000, 2)
    val t = startThread(a1, a2, 150000)
    val s = startThread(a2, a1, 150000)
    t.join()
    s.join()
  }

  def startThread(a: Account, b: Account, n: Int) = {
    val t = new Thread {
      override def run(): Unit = {
        for (i <- 0 until n) {
          a.transfer(b,1)
        }
      }
    }
    t.start()
    t
  }
}
