package exercices.exercice_classe

object ClassExerciceCorrection{
  def main(args: Array[String]): Unit = {
    val cochon = new Tirelire("Cochon") /* cochon est une instance de tirelire */
    println(cochon)
    cochon += 100
    println(cochon)
    cochon += 10
    println(cochon)
    cochon.vider()     /* équivalent de println(cochon.vider())  */
    cochon +=30
    println(cochon)
    cochon -= 50000
    println(cochon)


  }
  class Tirelire(
                  name : String = "Tirelire"
                ) {
    private var contenu: Int = 0

    /* += est une méthode */
    def +=(monnaie: Int) {
      contenu += monnaie
    }

    def -=(monnaie: Int) {
      if (0 < monnaie && monnaie <= contenu) {
        contenu -= monnaie
      } else throw(new Exception("Fonds insuffisants"))
    }

    def vider(): Int = {
      val solde = contenu;
      contenu = 0;
      solde
    }

    def combien: Int = contenu

    override def toString: String = s"$name contient (" + combien + ")"
  }

}


