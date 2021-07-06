package exercices.exercice_Euler

object projet_1 {
  def main(args: Array[String]): Unit = {
    println(s"The sum of all the multiples of 3 or 5 below 1000: ${multiples_of_three_and_five(0, 1000)}")
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
