import java.util.Scanner
import java.io.File
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.mutable

class Drvored (vrsta : String, brojStabla : Int) {
  def getVrsta : String = this.vrsta
  def getBrojStabla : Int = this.brojStabla

  override def toString: String = s"$getVrsta $getBrojStabla"
}

class Student( stdId : Int,
               drvoredi: ConcurrentLinkedQueue[Drvored],
               prikupljeno: mutable.HashMap[String, Int])
extends Thread {

  override def run() = {

    while (drvoredi.peek() != null) {

      println(s"Student $stdId je poceo da bere ")
      var drvored: Drvored = drvoredi.poll()
      for (d <- 0 until drvored.getBrojStabla) {

        Thread.sleep(ThreadLocalRandom.current.nextInt(0, 1000))
        val kolicina: Int = Math.ceil(ThreadLocalRandom.current.nextInt(29, 50)).toInt

        println(s"Prikupljeno: ${drvored.getVrsta}\nKolicina: $kolicina\nStudent:$stdId")

        prikupljeno(drvored.getVrsta) += kolicina

      }
    }
  }
}

object BerbaMain {

  def main(args: Array[String]) : Unit = {

    val inSc : Scanner = new Scanner(System.in)
    val drvoredSc : Scanner = new Scanner(new File("drvoredi.txt"))

    val drvoredi : ConcurrentLinkedQueue[Drvored] = new ConcurrentLinkedQueue[Drvored]()
    while (drvoredSc.hasNextLine) {
      drvoredi.add(new Drvored (drvoredSc.next(), drvoredSc.nextInt()))
    }

    val prikupljeno : mutable.HashMap[String, Int] = new mutable.HashMap[String, Int]()
    prikupljeno.put("tresnja", 0)
    prikupljeno.put("kajsija", 0)
    prikupljeno.put("kruska", 0)
    prikupljeno.put("sljiva", 0)

    val n_std : Int = inSc.nextInt()
    val studenti : Array[Student] = new Array[Student](n_std)
    for (i <- 0 until n_std)
      studenti(i) = new Student(i, drvoredi, prikupljeno)
    for (i <- 0 until n_std)
      studenti(i).start()
    for (i <- 0 until n_std)
      studenti(i).join()

    for (e <- prikupljeno) {
      println(s"${e._1} ${e._2}")
    }
  }
}