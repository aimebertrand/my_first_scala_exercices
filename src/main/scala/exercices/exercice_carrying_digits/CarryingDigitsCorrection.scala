package exercices.exercice_carrying_digits

object CarryingDigitsCorrection {
  def main(args: Array[String]): Unit = {
    println(carrying_digits(36, 135))
    println(carrying_digits(9671, 329))
    println(carrying_digits(1111, 3333))
    println(carrying_digits(53214, 956905))
    println(carrying_digits(53214, 999956905))
  }

  def carrying_digits(num1: Int, num2: Int): Int = {
    var cpt:Int=0
    var retenue:Boolean=false
    num1.toString.reverse.zipAll(num2.toString.reverse, '0','0')
      .map{
        elm =>
          val x = elm._1
          val y = elm._2
          (x.asDigit, y.asDigit)
      }
      .foreach{
        case(x,y) =>
          if(retenue){
            if(1+x+y >9){retenue=true; cpt=cpt+1}
            else{retenue=false}

          }else{
            if(x+y >9) {
              cpt += 1
              retenue=true
            }
          }
      }
    cpt
  }
}
