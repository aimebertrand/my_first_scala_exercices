package exercices.exercice_Euler


object projet_14 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The Longest Collatz sequence is:${Longest_Collatz_sequence(1000000L)}")//3711
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }

  def my_loop(j: Long):Long = {
    var res = j
    var mark = 0
    while (true) {
        if (res == 1){mark += 1;return mark}
        else if (res % 2 == 0) {res = res / 2; mark += 1}
        else {res = 3 * res + 1; mark += 1}
      }
    -84
  }

  def Longest_Collatz_sequence(j : Long):Long = {
    (13L to j).maxBy(my_loop)
  }
}

