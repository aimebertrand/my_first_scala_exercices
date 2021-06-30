package exercices.exercice_tic_tac_toe
import scala.util.{Failure, Success, Try}

class Board(p1: Char, p2: Char, size: Int) {
  def this() = {
    this('X', 'O', 3)
  }
  def this(p1: Char, p2: Char) = {
    this(p1, p2, 3)
  }

  def this(size: Int) = {
    this('X', '0')
  }

  def fill_map(): Unit = {
    for (i <- 0 until _map.length; j <- 0 until _map(0).length) {
      _map(i)(j) =
        if ((i == 0 && j == 0) || i == _map.length-1 && j == 0 || j == _map(0).length-1 && i == 0 || i == _map.length-1 && j == _map(0).length-1) '+'
        else if  (i == 0 || i == _map.length-1 ) '-'
        else if  (j == 0 || j == _map(0).length-1) '|'
        else ' '
    }
  }

  def update(tab : Array[String], p1 : Option [Char], p2 : Option [Char]) : Unit = {
      _map(tab(0).toInt)(tab(1).toInt) = p2.getOrElse(p1.get)
  }

  def print(): Unit = {
    for (i <- 0 until _map.length) {
      var line: String = ""
      for (j <- 0 until _map(0).length) {
        line += _map(i)(j)
      }
      println(line)
    }
  }
  var _map = Array.ofDim[Char](size + 2, size + 2)
}
