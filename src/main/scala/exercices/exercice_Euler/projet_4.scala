package exercices.exercice_Euler
import scala.collection.mutable.ListBuffer

object projet_4 {
  def main(args: Array[String]): Unit = {
    println(s"The largest palindrome : ${largest_palindrome(999, 999)}")
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
}
