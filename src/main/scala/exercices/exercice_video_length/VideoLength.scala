package exercices.exercice_video_length
import scala.collection.mutable.ArrayBuffer

object VideoLength {

  /*
  Consigne : Ecrire une fonction longueur_to_seconds(longeur) où longeur est une chaine de caractères
  sous la forme minutes:secondes qui retourne la longeur convertie en secondes
   Exemple :
     En entrée -  Durée : 5:33
     En sortie - Longueur en secondes : 333
     Cas particulier : si format invalide retourne -1

 */

  def main(args: Array[String]): Unit = {

    assert(longueur_to_seconds("01:00") == 60)
    assert(longueur_to_seconds("5:33") == 333)
    assert(longueur_to_seconds("61:00") == -1)
    assert(longueur_to_seconds("10") == -1)
    assert(longueur_to_seconds("10:7") == -1)
    assert(longueur_to_seconds("5rig:30") == -1)

  }

  def isAllDigits(x: String) = x forall Character.isDigit

  def longueur_to_seconds(longueur: String): Int = {
    if (!longueur.contains(':')) {return -1}
    var res = longueur.split(":")
    if (res(1).length < 2) {return -1}
    if (!isAllDigits(res(0)) || !isAllDigits(res(1)))
      return (-1)
    val min = res(0).toInt
    val sec = res(1).toInt
    if (min > 60  || sec > 60)
      return (-1)
    else
      return (min * 60 + sec)
  }
}