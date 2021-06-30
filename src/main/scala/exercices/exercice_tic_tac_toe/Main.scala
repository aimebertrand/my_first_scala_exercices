package exercices.exercice_tic_tac_toe
import scala.util.{Failure, Success, Try}

object Main {
  val usage = """"
Usage: run [-p1 CHAR1] [-p2 CHAR2] [-s GRID_SIZE]
  -p1 CHAR1: defines the character used by the first player (default: X)
  -p2 CHAR2: defines the character used by the second player (default: O, the letter)
  -s GRID_SIZE: defines the size of the grid (default: 3).
      """

  def isAllDigits(x: String) = x forall Character.isDigit


  def checkargs(p1 : String, p2 : String, size : String): Boolean = {
  if (!isAllDigits(size)) false
    true
  }

  def run_without_args(): Int = {
    val board = new Board()
    val game = new Game()
    var run = 0
    var tab2 = Array[String]("", "")

    board.fill_map()
    board.print()
    while (run == 0) {
      tab2 = game.get_input(board, "p1")
      board.update(tab2, Some('X'), None)
      board.print()
      tab2 = game.get_input(board, "p2")
      board.update(tab2, Some('O'), None)
      board.print()
    }
    return (run)
  }

  def run_with_args(tab : Array[String]) : Int = {
    val board = new Board(tab(1).head , tab(3).head, tab(5).toInt)
    val game = new Game()
    var run = 0
    var tab2 = Array[String]("", "")

    board.fill_map()
    board.print()
    while (run == 0) {
      tab2 = game.get_input(board, "p1")
      board.update(tab2, Some('X'), None)
      board.print()
      tab2 = game.get_input(board, "p2")
      board.update(tab2, Some('O'), None)
      board.print()
    }
    return (run)
  }


  def main(args: Array[String]): Unit = {

    val turn = Try {
      args(0)
      args(2)
      args(4)
      args(5)
    }
    turn match {
      case Failure(e) => {
        return run_without_args()
      }
      case Success(n) => if(!isAllDigits(n) || n.toInt <= 2 ||
        args.length > 6 || args(1).size > 1 || args(3).size > 1){
        System.err.println(usage)
        return 84
    }
      }
    return run_with_args(args)
  }
}