package exercices.exercice_building_word

/*
  Consigne : Ecrire une fonction can_build(words) qui retourne vrai si, pour chaque paire de mots
  consécutifs, on peut construire le second en ajoutant une seule lettre au début ou a la fin du premier mot
 */

object BuildingWord {
  def main(args: Array[String]): Unit = {
    assert(can_build(Seq("art", "cart", "carte")))
    assert(!can_build(Seq("art", "carte", "cartes")))
    assert(can_build(List("a", "at", "ate", "late", "plate", "plates")))
    assert(!can_build(List("a", "at", "ate", "late", "plate", "plater", "platter")))
  }

  def can_build(words: Seq[String]): Boolean = {
    for (i <- 0 until words.size - 1) {
      if (words(i).size != words(i + 1).size - 1 || !words(i + 1).contains(words(i)))
        return false
    }
    true
  }
}
