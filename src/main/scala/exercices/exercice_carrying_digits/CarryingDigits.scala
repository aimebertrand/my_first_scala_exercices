package exercices.exercice_carrying_digits

import scala.util.control.Breaks.{break, breakable}

/*
  Consigne : Ecrire une fonction carrying_digits(num1, num2) qui retourne le nombre de retenues
  lors de la somme entre num1 et num2
 */
object CarryingDigits {
  def main(args: Array[String]): Unit = {
    assert(carrying_digits(36, 135)==1)
    assert(carrying_digits(53214, 999956905)==7)
  }

  def carrying_digits(num1 : Int, num2 : Int) : Int = {
    val num1_str = num1.toString
    val num2_str = num2.toString
    var i = num2_str.size
    var j = num1_str.size
    var ret = 0
    var mark = false

    while (i != 0 && j != 0) {
        if (num2_str(i - 1) - 48 + num1_str(j - 1) - 48 > 9) {
          ret = ret + 1
          mark = true
        } else
          mark = false
      if (num2_str(i - 1) - 48  + num1_str(j - 1) - 48 > 9 && mark == true) {
        ret = ret + 1
      }
        i = i - 1
      j = j - 1
      mark = false
    }
    ret
  }
}