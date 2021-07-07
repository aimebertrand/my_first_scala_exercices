package exercices.exercice_nombres_premiers
import scala.util.control.Breaks._

/*
  Consigne : Ecrire une fonction premiers(n) qui retourne la liste des nombres premiers inférieurs à n
 */

object NombresPremiers {

  def main(args: Array[String]): Unit = {

    //println(premiers(500000).size)
    assert(premiers(500000).size == 41538)

  }

  def isPrime2 (n: Int): Boolean =
    (2 until n) forall (n % _ != 0)

  def isPrime(n: Int): Boolean = {
    var i = 3

    if (n < 2) { return false }
    if (n == 2) { return true }
    if (n % 2 == 0) { return false }

    while (i * i <= n) {
      if (n % i == 0) { return false }
      i += 2
    }
    true
  }

  def premiers(n: Int): Seq[Int] = {
    (2 to n) filter isPrime
  }
}
