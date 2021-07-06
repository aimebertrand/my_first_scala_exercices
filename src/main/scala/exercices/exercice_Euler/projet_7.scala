package exercices.exercice_Euler

object projet_7 {
  def main(args: Array[String]): Unit = {
    println(s"The 10001st prime number :${get_prime(10001)}")
  }

  def isPrime(n: Int): Boolean = {
    var i = 3

    if (n <= 2) {return false}
    if (n % 2 == 0) {return false}
    while (i * i <= n) {
      if (n % i == 0) {return false}
      i += 2
    }
    true
  }

  def get_prime(size: Int): Int = {
    var n = 1
    val tab = new Array[Int](size)
    tab(0) = 2
    var i = 3

    while (n < size) {
      if (isPrime(i)) {
        tab(n) = i; n += 1
      }
      i += 2
    }
    tab(tab.length - 1)
  }
}