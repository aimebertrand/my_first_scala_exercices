package exercices.exercice_Euler

import scala.annotation.tailrec

object projet_5 {
  def main(args: Array[String]): Unit = {
    println(s"Find smallest positive number that is evenly divisible by all of the numbers from 1 to 20 : ${smallest_multiple2()}")
  }

  def isDivis(x: Int): Boolean = {
    (1 to 20) forall {
      x % _ == 0
    }
  }

  @tailrec
  def smallest_multiple(n: Int): Int = {
    if (isDivis(n))
      n
    else
      smallest_multiple(n + 2)
  }

  /*
  plus efficace qu'avec les expressions car moins de contexte
   */
  def smallest_multiple2(): Int = {
    var i = 20
    while (i % 2 != 0 || i % 3 != 0 || i % 4 != 0 || i % 5 != 0 ||
      i % 6 != 0 || i % 7 != 0 || i % 8 != 0 || i % 9 != 0 ||
      i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
      i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
      i % 18 != 0 || i % 19 != 0 || i % 20 != 0) {
      i += 20
    }
    i
  }
}
