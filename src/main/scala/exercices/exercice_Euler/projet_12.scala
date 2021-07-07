package exercices.exercice_Euler

import scala.math.sqrt

object projet_12 {
  def main(args: Array[String]): Unit = {
    //println(s"The sequence of triangle numbers :${triangle(500)}")
    val t1 = System.nanoTime
    println(s"The sequence of triangle numbers :${triangle(500)}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }

  def get_triangle_number(n: Int): Int = {
    var res = n

    res = (res * (res + 1)) / 2
    res
  }
  def is_perfect_square(n : Int): Boolean = {
    val x = Math.sqrt(n);
    if (Math.pow(x,2) == n) {return true}
    false
  }

  def triangle(n: Int): Int = {
    var j = 1

    while (true) {
      var count = 0
      var triangle = get_triangle_number(j)
      var i = 1
      while (i < sqrt(triangle)) {
        if (triangle % i == 0) {
          count += 2
        }
        i = i + 1
      }
      if (is_perfect_square(triangle)) {count += 1}
      if (count > n) {return triangle}
    j = j + 1
    }
  -84
  }
}
