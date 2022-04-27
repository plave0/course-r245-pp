import org.apache.spark.{SparkConf, SparkContext}

import java.util.Scanner


object Fakt {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
      .setAppName("Fakt")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)

    val s : Scanner = new Scanner(System.in)
    val n = s.nextInt()
    s.close()

    val niz = (1 to n).toArray
    val res = sc
      .parallelize(1 to n)
      .map(x => (1 to x).product)
      .collect()
    sc.stop()

    println(res.mkString(" "))
  }
}