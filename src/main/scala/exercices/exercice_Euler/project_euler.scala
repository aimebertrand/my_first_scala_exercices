package exercices.exercice_Euler
import scala.collection.mutable.ListBuffer

object project_euler {
  def main(args: Array[String]): Unit = {
    println(s"1) The sum of all the multiples of 3 or 5 below 1000: ${multiples_of_three_and_five(0, 1000)}")
    println(s"2) The sum of the even-valued terms (Fibonacci): ${even_fibonacci_numbers(4000000)}")
    println(s"3) The largest prime factor : ${largest_prime_factor(600851475143L, 2L)}")
    println(s"4) Find the largest palindrome : ${largest_palindrome(999, 999)}")
    //println(s"Find smallest positive number that is evenly divisible by all of the numbers from 1 to 20 : ${smallest_multiple(2)}")
    println(s"5) Find smallest positive number that is evenly divisible by all of the numbers from 1 to 20 : ${smallest_multiple2()}")
    println(s"6) Sum square difference : ${sum_square_difference()}")
  }

  def sum_square_difference(): Int = {
    val j = List.range(1,101).map(Math.pow(_, 2)).sum.toInt
    val i = List.range(1,101).sum
    (i * i) - j
  }

  def isDivis(x:Int) = {
    (1 to 20) forall {x % _ == 0}
  }

  def smallest_multiple(n:Int):Int = {
    if (isDivis(n))
      n
    else
      smallest_multiple(n+2)
  }

  def smallest_multiple2(): Int = {
    var i = 20
    while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
    i %  6 != 0 || i %  7 != 0 || i %  8 != 0 || i %  9 != 0 ||
    i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
    i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
    i % 18 != 0 || i % 19 != 0 || i % 20 != 0) {
    i += 20;
  }
  return i
  }

  def is_palindrome(i : Int):Boolean = {
    val list  = i.toString.split("").toList
    list == list.reverse
  }

  def largest_palindrome(i : Int, j : Int): Int = {
  if (!is_palindrome(i) || !is_palindrome(i)) - 1
    val res = ListBuffer[Int]()
    for (i <- 100 to 999; j <- 100 to 999) {
        if (is_palindrome(i * j)) res+=(i * j)
    }
    res.max
  }

  def largest_prime_factor(number: Long, i : Long): Long =   {
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

  def even_fibonacci_numbers(n: Int): Int = {
    var res = 0
    var next = 0
    var i = 2
    var j = 1

    if (j >= n || !n.isValidInt) 0
    while (i <= n) {
      if (j >= 4000000) res
      if (i % 2 == 0) res += i
      next = i + j
      j = i
      i = next
    }
    //println(next)
    res
  }

  def multiples_of_three_and_five(i: Int, n: Int): Int = {
    if (i >= n || !i.isValidInt || !n.isValidInt)
      return 0
    if (i % 3 == 0 || i % 5 == 0) {
      i + multiples_of_three_and_five(i + 1, n)
    } else {
      multiples_of_three_and_five(i + 1, n)
    }
  }
}
