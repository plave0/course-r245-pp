import org.apache.spark.{SparkConf, SparkContext}

object Vektori {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Vektori")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)

    val v1rdd = sc
      .textFile("data/vektor1.txt")
      .flatMap(_.split(", "))
      .filter(_.isEmpty == false)
      .map(_.toInt)

    val v2rdd = sc
      .textFile("data/vektor2.txt")
      .flatMap(_.split(", "))
      .filter(_.isEmpty == false)
      .map(_.toInt)

    var dot = v1rdd.zip(v2rdd)
      .map(t => t._1 * t._2)
      .sum()

    // Tek kada pozivamo sum, sve ostalo se izracunava

    println(dot)

    sc.stop()
  }
}