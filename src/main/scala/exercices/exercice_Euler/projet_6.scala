package exercices.exercice_Euler

import exercices.exercice_Euler.projet_5.smallest_multiple2

object projet_6 {
  def main(args: Array[String]): Unit = {
    println(s"Sum square difference : ${sum_square_difference()}")
  }
  def sum_square_difference(): Int = {
    val j = List.range(1, 101).map(Math.pow(_, 2)).sum.toInt
    val i = List.range(1, 101).sum
    (i * i) - j
  }
}

