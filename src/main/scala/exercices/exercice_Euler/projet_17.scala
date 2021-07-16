package exercices.exercice_Euler

import scala.util.control.Breaks.{break, breakable}

object projet_17 {

  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The numbers of letters is :${number_letter_count(1000)}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }
  val one:Map[Int, String] = Map(0 -> "", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven", 8 -> "eight", 9 -> "nine")
  val ten:Map[Int ,String] = Map(0 -> "", 2 -> "twenty", 3 -> "thirty", 4 -> "forty", 5 -> "fifty", 6 -> "sixty", 7 -> "seventy", 8 -> "eighty", 9 -> "ninety")
  val teen:Map[Int, String] = Map(10 -> "ten", 11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen")

  def tens(i : Int) : String = {

    if (i < 10) {one(i % 10)}
    else if (i < 20) {teen(i)}
    else
      List(ten(i / 10), one(i % 10)).filter(_ != "").mkString(" ")
  }

  def hundred(i : Int): String = {

    i / 100 match {
      case 0 => ""
      case 10 => "one thousand"
      case n => one(n % 10) + " hundred"
    }
  }

  def number_letter_count(n : Int) : Int = {

    var res : String = ""
    for (i <- 1 to n) {
      res += List(hundred(i), tens(i % 100)).filter(_ != "").mkString(" and ").replaceAll(" ", "")
    }
    res.length
  }
/*
  def if_tree(n: Int): Int = {
    val one = Array("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
    "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = Array(None, None, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
    var res : String = null

    for (i <- 1 to n) {
      breakable {
        if (i >= 0 && i < 20) {res += one(i); break}
        if (i >= 20 && i <= 90 && i % 10 == 0) {res += tens((i / 10).floor.toInt);break}
        if ( i > 20 && i < 100) {res +=tens((i / 10).floor.toInt) + one(i % 10);break}
        if ( i >= 100 && i <= 900 && i % 100 == 0) {res +=one((i / 100).floor.toInt) + "hundred";break}
        if ( i > 100 && i < 120) {res +=one((i / 100).floor.toInt) + "hundredand" + /*(tens(((i % 100) / 10).floor.toInt) +*/ one(i % 100);break}
        if ( i > 100 && i < 1000 && i % 10 == 0 ) {res +=one((i / 100).floor.toInt) + "hundredand" +/* (tens(((i % 100) / 10).floor.toInt) + */one(((i % 100)));break}
        if ( i > 100 && i < 1000) {res +=one((i / 100).floor.toInt) + "hundredand" + (tens(((i % 100) / 10).floor.toInt) + one(((i % 100) / 100).floor.toInt));break}
        if (i == 1000) {res += "onethousand"}
        /*if (i >= 20 && i < 100) {res += tab2((i / 10) - 2)
          if (i % 10 != 0) {res += tab(i % 10)};break}
        if (i ==  100) {res += "onehundred"}
       // if (i > 100 && i < 110) {res += tab(i / 100) + "hundredand" + (tab((i % 100) + 1)); break}
        if (i >= 100 && i <= 900 && i % 100 == 0)
          res +=*/
          //if (i >= 20 && i <= 90 && i % 10 == 0 ) {res += tab2(i % 10)}
        //if (i > 20 && i < 100) {res += (tab2(i) + "-" + tab(i % 10))}
      }
      }
    println(res)
    res.length
  }
 */
}