var uidCount = 0L
val x = new AnyRef {}

def getUniqueId(): Long = x.synchronized {
  uidCount = uidCount + 1
  uidCount
}

def startThread() = {
  val t = new Thread {
    override def run() {
      val uids = for (i <- 1 until 10) yield getUniqueId()
      println(uids)
    }
  }

  t.start()
  t
}

startThread()
startThread()

