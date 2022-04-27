import org.apache.spark.{SparkContext, SparkConf}

object Log {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Log")
      .setMaster("local[4]")

    val sc : SparkContext = new SparkContext(conf)

    val res = sc
      .textFile("data/log.txt")
      .filter(line =>
          line.contains("java") &&
          (
            line.startsWith("[info] ") ||
            line.startsWith("[warn] ") ||
            line.startsWith("[error] ")
          )
      )
      .map(line => {
        val spl = line.split(" ")
        (spl(0), spl.drop(1).mkString(" "))
      })
      .groupByKey()
      .map(kvp => (kvp._1, kvp._2.size))
      .collect()

    sc.stop()

    res.foreach(println(_))
  }
}