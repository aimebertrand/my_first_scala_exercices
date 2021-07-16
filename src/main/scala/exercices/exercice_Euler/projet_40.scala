package exercices.exercice_Euler

object projet_40 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"champerpowns :${champernowne(1000000L)}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }
def champernowne(n: Long): Long = {
  var  i = 1L
  var j = 1L
  val str: String = (1L to n).mkString
  while (i <= n) {
    j *= Integer.parseInt(str.charAt((i - 1).toInt)+"")
    i *= 10L
    }
  j
  }
}

