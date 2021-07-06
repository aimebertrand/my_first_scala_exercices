package exercices.exercice_Euler

object projet_2 {
  def main(args: Array[String]): Unit = {
    println(s"The sum of the even-valued terms (Fibonacci): ${even_fibonacci_numbers(4000000)}")
  }

  def even_fibonacci_numbers(n: Int): Int = {
    var res = 0
    var next = 0
    var i = 2
    var j = 1

    if (j >= n || !n.isValidInt) {return 0}
    while (i <= n) {
      if (j >= 4000000) {return res}
      if (i % 2 == 0) res += i
      next = i + j
      j = i
      i = next
    }
    res
  }
}
