import org.apache.spark.{SparkConf, SparkContext}

object Temperatura {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Temperatura")
      .setMaster("local[4]")

    val sc : SparkContext = new SparkContext(conf)

    val res = sc
      .textFile("data/temperatureBoston.txt")
      .map(line => {
        val spl = line.trim.split(" ")
        (spl(2).toInt, spl(3).toDouble)
      })
      .aggregateByKey((0.0, 0))((acc, v) => (acc._1 + v, acc._2 + 1),
                                (acc1, acc2) => (acc1._1 + acc2._2, acc1._2 + acc2._2))
      .map(kvp => {
        val tempF = kvp._2._1 / kvp._2._2
        val tempC = (tempF - 32.0) / 1.8
        (kvp._1, tempC)
      })
      .sortByKey()
      .collect()

    sc.stop()

    res.foreach(kvp => println(s"${kvp._1}: ${kvp._2}"))
  }
}