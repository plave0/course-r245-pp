import java.util.Scanner
import java.io.File

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

class Ucesnik( indeks : Int,
               imePrezime : String,
               cena: Int,
               nagrade : Array[Int])
extends Thread {
  override def run() {

    nagrade.synchronized {
      nagrade.wait()
    }

    if (nagrade.contains(indeks)) {
      println(s"Nagradu je dobio/la: $imePrezime\nSnizena cena karte: ${cena - cena * 0.2}")
    }
  }
}


object NagradaMain {
  def main(args : Array[String]) : Unit = {

    val sc : Scanner = new Scanner(new File("ucesnici.txt"))

    val ucesnici : ArrayBuffer[Ucesnik] = new ArrayBuffer[Ucesnik]()
    val nagrade : Array[Int] = new Array[Int](5)

    var indeks : Int = 0
    while(sc.hasNext()) {
      val imePrezime : String = sc.nextLine()
      val cena : Int = sc.nextInt()
      if (sc.hasNextLine)
        sc.nextLine()
      ucesnici.append(new Ucesnik(indeks, imePrezime, cena, nagrade))
      indeks += 1
    }
    sc.close()

    for(u <- ucesnici)
      u.start()

    var indeksNagrade : Int = 0
    while(indeksNagrade < 5) {
      val br : Int = Random.nextInt(ucesnici.size)

      if(!nagrade.contains(br)) {
        nagrade(indeksNagrade) = br
        indeksNagrade += 1
      }
    }

    nagrade.synchronized {
      nagrade.notifyAll()
    }
  }
}