package exercices.exercice_Euler

import scala.annotation.tailrec

//non fini
object projet_684 {
  def main(args: Array[String]): Unit = {
    println(s"inverse_digit_sum : ${inverse_digit_sum(0)}")
  }

  def get_value(i: Long): Long = {
    var j = i
    val n = j / 9
    val rest = j % 9
    val scale = Math.pow(10, n).toInt
    val res = rest * scale + (scale - 1)
    //println(s"res : $result")
    res
  }
  def fib( n : Long) : Long = {
    @tailrec
    def fib_tail(n: Long, a :Long, b :Long): Long = n match {
      case 0 => a
      case _ => fib_tail(n - 1, b, a + b)
    }
    fib_tail(n, 0, 1)
  }
  def inverse_digit_sum(k : Long) : Long = {
    var j : Long = 0
    for (w <- 0 to 90) {
      var i = fib(w)
      j += List.range(1, i).map(x => get_value(x)).sum
      // j = j % 1000000007
      println(w)
    }
    j = j % 1000000007
    println(s"j == $j")
    j
  }
}