import org.apache.spark.{SparkConf, SparkContext}

object Petocifreni {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Petocifreni")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)

    // Vraca RDD stringova - svaka linija je jedan string
    val res = sc.textFile("data/brojevi.txt")
      .filter(_.length == 5)
      .count()

    sc.stop()

    println(res)
  }
}