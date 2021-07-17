package exercices.exercice_Euler

import scala.annotation.tailrec

object projet_37 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The numbers of truncable primes is :${run()}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }


  def run() : String = {
    var sum = 0
    var count = 0
    var n = 11
    while (count < 10) {
      if (is_truncable(n)) {sum += n;count += 1}
      n += 1
    }
    (sum + 23).toString
  }

  def isPrime(n: Long): Boolean = {
    var i = 3L

    if (n <= 2L) {return false}
    if (n % 2L == 0) {return false}
    while (i * i <= n) {
      if (n % i == 0) {return false}
      i += 2L
    }
    true
  }

  @tailrec
  def right_prime(n: Int): Boolean = {
    if (!isPrime(n)) false
    else if (n < 10) true
    else right_prime(n.toString.init.toInt)
  }

  @tailrec
  def left_prime(n: Int): Boolean = {
    if (!isPrime(n)) false
    else if (n < 10) true
    else left_prime(n.toString.tail.toInt)
  }

  def is_truncable(j: Int): Boolean = {
    if (!left_prime(j) || !right_prime(j)){return false}
    true
  }
}
