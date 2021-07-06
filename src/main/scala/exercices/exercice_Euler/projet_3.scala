package exercices.exercice_Euler

import scala.annotation.tailrec

object projet_3 {
  def main(args: Array[String]): Unit = {
    println(s"The largest prime factor : ${largest_prime_factor(600851475143L, 2L)}")
  }

  @tailrec
  def largest_prime_factor(number: Long, i: Long): Long = {
    if (i * i > number) number
    else if (number % i == 0) largest_prime_factor(number / i, i)
    else largest_prime_factor(number, i + 1)
    /*val range = 2L to number
    for (n <- range if number % n == 0) {
      return largest_prime_factor(number / n, list :+ n)
    }*/
    //println(list.tail)
    //list.tail.last
  }
}
