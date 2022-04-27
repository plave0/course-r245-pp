import org.apache.spark.{SparkContext, SparkConf}

object Pokloni {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Pokloni")
      .setMaster("local[4]")

    val sc : SparkContext = new SparkContext(conf)

    val res = sc
      .textFile("data/zaposleni.txt")
      .map(line => {
        val spl = line.split(" ")
        (spl(3), spl(0), spl(1), spl(6))
      })
      .filter(tup => tup._4.equalsIgnoreCase("it_prog"))
      .takeSample(withReplacement = false, num = 3)

    sc.stop()

    println(res.mkString("\n"))
  }
}