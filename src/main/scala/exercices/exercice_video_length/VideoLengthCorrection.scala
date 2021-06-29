package exercices.exercice_video_length

import scala.util.Try

object VideoLengthCorrection {

  def main(args: Array[String]): Unit = {
    println(longueur_to_seconds("5:30"))
    println(longueur_to_seconds("6:3"))
    println(longueur_to_seconds("5:65"))
    println(longueur_to_seconds("5rig:30"))
    println(longueur_to_seconds("100:00"))

    assert(longueur_to_seconds("01:00") == 60)
  }

  def longueur_to_seconds(longueur: String): Int = {
    val minutes_and_seconds: Array[Int] = longueur
      .split(":")         // Le séparateur attendu est ":" donc on coupe la string selon ce charactère
      .flatMap(elm => Try{elm.toInt}.toOption) // On essaye de convertir les éléments de la liste en Int, si on ne peut pas, l'élément est supprimé de la liste
    if(minutes_and_seconds.length!=2 || minutes_and_seconds.last > 60 || minutes_and_seconds.exists(_ < 0)){
      -1
    } else{
      minutes_and_seconds.head * 60 + minutes_and_seconds.last
    }
  }

}


