package exercices.exercice_nombres_premiers
import scala.collection.immutable

object NombresPremiersCorrection {
  def main(args: Array[String]): Unit = {
    val limit_premiers = 500000
    val liste_premiers = premiers(limit_premiers)
    println(liste_premiers.size)
    println(s"Nombre de premiers < $limit_premiers : ${liste_premiers.size}")
    println(s"le plus grand premier < $limit_premiers : ${liste_premiers.max}")

    assert(premiers(500000).size == 41538)

  }

  def premiers(n: Int): Seq[Int] = {
    (2 to n)
      .filter {
        p =>
          val k_values = 2 to Math.sqrt(n).toInt
          k_values.find(
            k => p % k == 0 && p > k
          ) match {
            case Some(_) => false
            case None => true
          }
      }
  }

  // Autre possibilité qui utiliserai la fonction isPrime(n)
  def isPrime(n: Int): Boolean = {
    List.range(2, Math.sqrt(n).toInt+1) forall (x => n % x != 0)
  }

  def premiers_bis(n: Int):  Seq[Int] = {
    (2 to n).filter(isPrime)
  }

}
