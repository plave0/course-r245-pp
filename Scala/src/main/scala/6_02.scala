import java.util.Scanner
import java.util.concurrent.ThreadLocalRandom
import scala.util.Random

class Adder(c : Int, i : Int, a : Array[Int]) extends Thread() {
  override def run(): Unit = {
    a(i) += c
    Thread.sleep(ThreadLocalRandom.current().nextInt(1,5) * 1000)
    println(s"Thread $i ended")
  }
}

object AdderMain {
  def main(args: Array[String]) : Unit = {

    val sc : Scanner = new Scanner(System.in)
    val n = sc.nextInt()

    val a = new Array[Int](n)
    val ths = new Array[Thread](n)

    for(i <- 0 until n)
      ths(i) = new Adder(i, i, a)

    for(i <- 0 until n)
      ths(i).start()

    for(i <- 0 until n)
      ths(i).join()

    for(x <- a)
      print(x + " ")
    println()
  }
}