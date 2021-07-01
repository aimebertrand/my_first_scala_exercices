package exercices.exercice_Euler

import exercices.exercice_carrying_digits.CarryingDigits.carrying_digits

object project_euler {
  def main(args: Array[String]): Unit = {
    println(s"1) The sum of all the multiples of 3 or 5 below 1000: ${multiples_of_three_and_five(0, 1000)}")
    println(s"2) The sum of the even-valued terms (Fibonacci): ${even_fibonacci_numbers(4000000)}")
    println(s"3) The largest prime factor : ${largest_prime_factor(600851475143L, 2L)}")
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
