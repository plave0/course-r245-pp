import java.util.Scanner
import java.util.concurrent.ThreadLocalRandom

class Konobar(id : Int, start: Int, end : Int) extends Thread() {
  override def run() : Unit = {
    for(i <- start until end) {
      Thread.sleep(ThreadLocalRandom.current.nextInt(0, 5) * 1000)
      println(s"Konobar $id je usluzio sto $i")
    }
  }
}


object RestoranMain{
  def main(args: Array[String]) : Unit = {

    val sc : Scanner = new Scanner(System.in)
    val n_stolova : Int = sc.nextInt
    sc.close()

    val skorak : Int = math.ceil(n_stolova.toDouble / 5).toInt
    val ths : Array[Thread] = new Array[Thread](5)

    for(k <- 0 until 5) {
      ths(k) = new Konobar(k, k * skorak, math.min((k+1) * skorak, n_stolova))
      ths(k).start()
    }

    for(k <- 0 until 5) {
      ths(k).join()
    }

  }
}