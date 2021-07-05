package exercices.exercice_tic_tac_toe
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class Input {

  def isAllDigits(x: String): Boolean = x forall Character.isDigit

  def check_format(n: String): Boolean = {
    if (n.length != 3 || n.count(_ == ',') == 0 || n.length == 3 && n(2) == ','
    || !isAllDigits(n.split(',')(1)) || !isAllDigits(n.split(',')(0)))
      return false
    true
  }
  def check_range(n: String, board : Board): Boolean = {
    if (n.split(',')(1).toInt >= board._map.length - 1
    || n.split(',')(0).toInt >= board._map.length - 1
    || n.split(',')(1).toInt <= 0
    || n.split(',')(0).toInt <= 0
    || board._map(n.split(',')(0).toInt)(n.split(',')(1).toInt) == board._p1 // beaucoup d'opération couteuse pour pas grand chose
    || board._map(n.split(',')(0).toInt)(n.split(',')(1).toInt) == board._p2)
      return false
    true
  }

  def get_input (board : Board, name : String) : Array[String] = {
    // Une mauvaise utilisation du Try - match ??
    println(s"Player $name >")
    val turn = Try {
      StdIn.readLine()
    }
    turn match {
      case Failure(e) =>
        println("Error reading input: " + e)
        println("Please insert an integer")
        get_input(board, name)
      case Success(n) if !check_format(n) =>
        println("invalid format")
        println("please insert two Int separated by ','")
        get_input(board, name)
      case Success(n) if !check_range(n, board) =>
        println("Invalid range input: " + n)
        println("Please insert an other number")
        get_input(board, name)
      case Success(n) => n.split(',')
    }
  }
}
