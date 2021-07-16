package exercices.exercice_Euler

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object projet_35 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The numbers of circular primes is :${circular_primes(1000000)}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }

  def isPrime(n: Long): Boolean = {
    var i = 3L

    if (n <= 2L) {
      return false
    }
    if (n % 2L == 0) {
      return false
    }
    while (i * i <= n) {
      if (n % i == 0) {
        return false
      }
      i += 2L
    }
    true
  }

  def countDigits(l: Int): Double = {
    var res = 0d
    var i = l
    while (i > 0) {
      res += 1; i /= 10
    }
    res
  }

  def rotate(n: Int): mutable.Seq[Int] = {
    var d = countDigits(n)
    var power = math.pow(10, d - 1).toInt
    var i = 0
    var left = 0
    var num = n
    var res: ListBuffer[Int] = ListBuffer(n)
    while (i < d - 1) {
      var fd = num / power
      left = (num * 10) + fd - (fd * power * 10)
      i += 1
      num = left
      res += left
    }
    res
  }

  def circular_primes(n: Long): Int = {
    val res = (0L until n).filter(isPrime)
    res.filter(x => {rotate(x.toInt).forall(isPrime(_))}).size+1
  }
}
