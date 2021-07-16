package exercices.exercice_Euler
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.DAY_OF_WEEK
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.JANUARY
import java.util.GregorianCalendar

object projet_19 {
  def main(args: Array[String]): Unit = {
    val t1 = System.nanoTime
    println(s"The numbers of sundays is :${counting_sundays()}")
    val duration = (System.nanoTime - t1) / 1e9d
    println(s"\ntime elapsed : $duration")
  }

  def counting_sundays(): Int = {
    val i = new GregorianCalendar(1901, JANUARY, 1)
    val j = new GregorianCalendar(2001, JANUARY, 1)
    var count = 0

    while (i.before(j)) {
      if (i.get(DAY_OF_WEEK) == 1 && i.get(DAY_OF_MONTH) == 1)
        count = count + 1
      i.add(DAY_OF_YEAR, 1)
    }
    count
  }
}