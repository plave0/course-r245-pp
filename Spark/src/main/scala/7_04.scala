import org.apache.spark.{SparkConf, SparkContext}

object Knjiga {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Knjiga")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)

    val res : Unit = sc
      .textFile("data/knjiga.txt")
      .flatMap(_.split("\\b+"))
      .filter(_.count(_.isLetter) > 1)
      .map(rec => (rec, 1))
      .reduceByKey(_+_)
      .sortBy(t => t._2, ascending = false)
      .saveAsTextFile("word_count")

    sc.stop()
  }
}