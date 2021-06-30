package exercices.exercice_tic_tac_toe
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class Game {

  def isAllDigits(x: String) = x forall Character.isDigit

  def get_input (board : Board, name : String) : Array[String] = {
    println(s"Player $name >")
    val turn = Try {
      StdIn.readLine()
    }
    turn match {
      case Failure(e) => {
        println("Error reading input: " + e)
        println("Please insert an integer")
        //board.print()
        get_input(board, name)
      }
      case Success(n) if (n.size != 3 || !isAllDigits(n.split(',')(1)) || !isAllDigits(n.split(',')(0))) => {
        println("invalid format")
        println("please insert two Int separated by ','")
        get_input(board, name)
      }
      case Success(n) if(n.split(',')(1).toInt >= board._map.size - 1 || n.split(',')(0).toInt >= board._map.size - 1) => {
        println("Invalid range input: " + n)
        println("Please insert a positive number or a smaller number")
        //board.print()
        get_input(board, name)
      }
      case Success(n) => n.split(',')
    }
  }
}
