import org.apache.spark.{SparkContext, SparkConf}

object Preuzimanja {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Preuzimanja")
      .setMaster("local[4]")

    val sc : SparkContext = new SparkContext(conf)

    val cached = sc.textFile("data/mavenLog.txt")
      .cache()

    val downloading = cached
      .filter(_.startsWith("Downloading:"))
      .count()

    val downloaded = cached
      .filter(_.startsWith("Downloaded:"))
      .count()

    sc.stop()

    println(downloaded.toDouble / downloading.toDouble)
  }
}