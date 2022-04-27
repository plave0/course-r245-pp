import org.apache.spark.{SparkConf, SparkContext}
import java.io.{File, PrintWriter}

object Transakcije {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Transakcije")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)

    val res = sc
      .textFile("data/uredjaji.txt")
      .map(linija => {
        val delovi = linija.split(" ")
        (delovi(0), delovi.drop(1).mkString(" "))
      })
      .groupByKey()
      .collect()
      // Neciste funkcije radimo nakon collect
      // Najbolje je da se ne koristi foreach zbog uvodjenja interaktivne paradigme
      // Na ispitu je zabranjeno koristiti foreach
      .foreach(t => {
        val f = new PrintWriter(new File(t._1 + ".txt"))
        t._2.foreach(d => f.println(d))
        f.close()
      })

    sc.stop()
  }
}