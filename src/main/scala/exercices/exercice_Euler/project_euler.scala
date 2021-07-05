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
    //println(s"inverse digit sum  : ${inverse_digit_sum(20)}")
    //println(s"7)thousand prime ${thousand_st_prime()}")
    //println(s"3) The largest prime factor : ${largest_prime_factor(10001L, 2L)}")
    //println(s"largest_product_series ${"73167176531330624919225119674426574742355349194934\n96983520312774506326239578318016984801869478851843\n85861560789112949495459501737958331952853208805511\n12540698747158523863050715693290963295227443043557\n66896648950445244523161731856403098711121722383113\n62229893423380308135336276614282806444486645238749\n30358907296290491560440772390713810515859307960866\n70172427121883998797908792274921901699720888093776\n65727333001053367881220235421809751254540594752243\n52584907711670556013604839586446706324415722155397\n53697817977846174064955149290862569321978468622482\n83972241375657056057490261407972968652414535100474\n82166370484403199890008895243450658541227588666881\n16427171479924442928230863465674813919123162824586\n17866458359124566529476545682848912883142607690042\n24219022671055626321111109370544217506941658960408\n07198403850962455444362981230987879927244284909188\n84580156166097919133875499200524063689912560717606\n05886116467109405077541002256983155200055935729725\n71636269561882670428252483600823257530420752963450"}")
  }

  def sum_square_difference(): Int = {
    val j = List.range(1, 101).map(Math.pow(_, 2)).sum.toInt
    val i = List.range(1, 101).sum
    (i * i) - j
  }

  def isDivis(x: Int) = {
    (1 to 20) forall {
      x % _ == 0
    }
  }

  def smallest_multiple(n: Int): Int = {
    if (isDivis(n))
      n
    else
      smallest_multiple(n + 2)
  }

  /*
  plus efficace qu'avec les expressions
   */
  def smallest_multiple2(): Int = {
    var i = 20
    while (i % 2 != 0 || i % 3 != 0 || i % 4 != 0 || i % 5 != 0 ||
      i % 6 != 0 || i % 7 != 0 || i % 8 != 0 || i % 9 != 0 ||
      i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
      i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
      i % 18 != 0 || i % 19 != 0 || i % 20 != 0) {
      i += 20;
    }
    return i
  }

  def is_palindrome(i: Int): Boolean = {
    val list = i.toString.split("").toList
    list == list.reverse
  }

  def largest_palindrome(i: Int, j: Int): Int = {
    if (!is_palindrome(i) || !is_palindrome(i)) -1
    val res = ListBuffer[Int]()
    for (i <- 100 to 999; j <- 100 to 999) {
      if (is_palindrome(i * j)) res += (i * j)
    }
    res.max
  }

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
/*
Projet 684 proposé par Pascal. Ni lui ni moi n'avons réussi à le finir.
*/
/*
  def get_value(i: Long): Long = {
    var j = i
    val n = j / 9
    //println(s"n : $n")
    val rest = j % 9
    //println(s"rest : $rest")
    val scale = Math.pow(10, n).toInt
    //println(s"scale : $scale")
    val res = rest * scale + (scale - 1)
    //println(s"res : $result")
    res
  }
def fib( n : Long) : Long = {
  def fib_tail( n: Long, a :Long, b :Long): Long = n match {
    case 0 => a
    case _ => fib_tail(n - 1, b, a + b)
  }
  return fib_tail(n, 0, 1)
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
*/




/*  def largest_product_series(str: String): Int {
0
  }
*/




/*def  thousand_st_prime(): Int = {

  if (i <= 1)
      false
    else if (i == 2)
      true
    else
      !(2 until i).exists(n => i % n == 0)
i
}*/
