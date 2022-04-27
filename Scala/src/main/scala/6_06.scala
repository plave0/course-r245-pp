import java.util.Scanner

class VectorMul (v1 : Array[Int],
                 v2 : Array[Int],
                 start : Int,
                 end: Int)
  extends Thread {
  override def run() : Unit = {

    for(i <- start until end)
      v1(i) += v2(i)
  }
}

object VectorMain {
  def main(args : Array[String]) : Unit = {

    val sc : Scanner = new Scanner(System.in)

    val n : Int = sc.nextInt()
    val v1 : Array[Int] = new Array[Int](n)
    val v2 : Array[Int] = new Array[Int](n)

    for (i <- 0 until n)
      v1(i) = sc.nextInt()
    for (i <- 0 until n)
      v2(i) = sc.nextInt()

    val n_th : Int = sc.nextInt()
    val ths : Array[VectorMul] = new Array[VectorMul](n_th)

    val step : Int = Math.ceil(n / n_th.toDouble).toInt
    for (i <- 0 until n_th) {
      ths(i) = new VectorMul(v1, v2, i * step, Math.min((i+1) * step, n))
      ths(i).start()
    }

    for (i <- 0 until n_th)
      ths(i).join()

    for (i <- 0 until n)
      print(s"${v1(i)} ")
    println()

  }
}