import java.util.Scanner
import java.io.{File, PrintWriter}
import scala.Array.ofDim

class MatMul (mat1 : Array[Array[Int]],
              mat2 : Array[Array[Int]],
              rowIndex : Int,
              res : Array[Int]) extends Thread {
  override def run() : Unit = {
    for(k <- 0 until res.length) {

      res(k) = 0;
      for (j <- 0 until mat2(k).length) {
        res(k) += mat1(rowIndex)(j) * mat2(j)(k)
      }

    }
  }
}

object MatMain {
  def main(args : Array[String]) : Unit = {

    val sc1 : Scanner = new Scanner(new File("matrica1.txt"))
    val sc2 : Scanner = new Scanner(new File("matrica2.txt"))

    val n1 : Int = sc1.nextInt
    val m1 : Int = sc1.nextInt
    val n2 : Int = sc2.nextInt
    val m2 : Int = sc2.nextInt

    val mat1 : Array[Array[Int]] = ofDim[Int](n1, m1)
    val mat2 : Array[Array[Int]] = ofDim[Int](n2, m2)

    for(i <- 0 until n1) {
      for (j <- 0 until m1) {
        mat1(i)(j) = sc1.nextInt()
      }
    }

    for(i <- 0 until n2) {
      for (j <- 0 until m2) {
        mat2(i)(j) = sc2.nextInt()
      }
    }

    sc1.close()
    sc2.close()

    val mat3 : Array[Array[Int]] = ofDim[Int](n1, m2)
    val ths : Array[Thread] = new Array[Thread](n1)

    for (i <- 0 until n1) {
      ths(i) = new MatMul(mat1, mat2, i, mat3(i))
      ths(i).start()
    }

    for (i <- 0 until n1) {
      ths(i).join()
    }

    val pw : PrintWriter = new PrintWriter(new File("matrica3.txt"))

    pw.append(s"$n1 $m2 \n")
    for (i <- 0 until n1) {
      for (j <- 0 until m2) {
        pw.append(s"${mat3(i)(j)} ")
      }
      pw.append("\n")
    }
    pw.close()

  }
}