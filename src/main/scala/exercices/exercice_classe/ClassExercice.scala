package exercices.exercice_classe

/*
  Consigne : Implémenter une classe Tirelire qui possède un nom et un contenu
  On veut pouvoir passer le nom en argument, par défaut il doit valoir "Tirelire"
  La class doit avoir une méthode += qui permet d'augmenter la valeur du contenu de la tirelire
  La class doit avoir une méthode -= qui permet de réduire la valeur du contenu de la tirelire
  La class doit avoir une méthode vider qui permet de réinitialiser le contenu de la tirelire à 0
  La class doit avoir une méthode combien qui retourne le contenu de la tirelire
  La class doit avoir une méthode toString qui affiche le contenu de la tirelire et son nom

 */

object ClassExercice {

  def main(args: Array[String]): Unit = {
    /*val cochon = new Tirelire()
    cochon.+=(5)
    cochon.-=(2)
    cochon.toString()
    cochon.vider()
    cochon.+=(5)
    println(cochon.combien())
    println(cochon.toString())*/
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

  class Tirelire( val name : String, private var money: Int) {
    def this(money: Int) = {
      this("Tirelire", money)
      println("\nNo name given.")
    }

    def this(name: String) = {
      this(name, 0)
      println("\nNo money given.")
    }

    def this() = {
      this("Tirelire", 0)
      println("\nNo name given or money given.")
    }

    def +=(more: Int) = {
      money += more
    }

    def -=(more: Int) = {
      money -= more
      if (money < 0)
        money = 0;
    }

    def vider() = {
      money = 0
    }

    def combien(): Int = {
      return money
    }

    override def toString() : String = {

      return "Contenu : " + money +
      ", Nom : " + name+"";
    }
  }
}