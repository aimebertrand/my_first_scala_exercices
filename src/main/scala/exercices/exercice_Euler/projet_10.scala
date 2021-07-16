package exercices.exercice_Euler

object projet_10 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The sum of all the primes below two million :${premiers(2000000L)}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }

  def isPrime(n: Long): Boolean = {
    var i = 3

    if (n <= 2) {return false}
    if (n % 2 == 0) {return false}
    while (i * i <= n) {
      if (n % i == 0) {return false}
      i += 2
    }
    true
  }

  def premiers(n: Long): Long = {
    (2L to n).filter(isPrime).sum + 2
  }
}
  /*def get_prime(size: Long): Long = {
    var res = 0
    var i = 3

    while (i < size) {
      if (isPrime(i)) {res += i}
      i += 2
    }
    res + 2
  }
}
*/
