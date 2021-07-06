package exercices.exercice_tic_tac_toe
import scala.util.{Failure, Success, Try}

object Main {
  val usage = """"
Usage: run [-p1 CHAR1] [-p2 CHAR2] [-s GRID_SIZE]
  -p1 CHAR1: defines the character used by the first player (default: X)
  -p2 CHAR2: defines the character used by the second player (default: O, the letter)
  -s GRID_SIZE: defines the size of the grid (default: 3).
      """

  def isAllDigits(x: String): Boolean = x forall Character.isDigit

  def run_my_game(name : String, board : Board, input : Input, c : Char) : Boolean = {
    var tab2 = Array[String]("", "")

    tab2 = input.get_input(board, name)
    board.update(tab2, Some(c), None)
    board.print()
    board.did_won(tab2(0).toInt, tab2(1).toInt)
  }

  def check_draw(map : Array[Array[Char]]): Boolean = {
    for (i <- map.indices) {
      for (j <- map(0).indices) {
        if (map(i)(j) == ' ') {return true}
      }
    }
    false
  }

  def run_without_args(): String = {
    val board = new Board()
    val input = new Input()

    board.fill_map()
    board.print()
    // Boucle de type C que j'aimerais plutot faire avec une expression
    while (true) {
      if (!check_draw(board._map)) {return "It is a draw !"}
      if (run_my_game("p1", board, input, 'X')) {return "Player 1 won !"}
      if (run_my_game("p2", board, input, 'O')) {return "Player 2 won !"}
    }
    "seriously, how did I get here?"
  }

  def run_with_args(tab : Array[String]) : String = {
    val board = new Board(tab(1).head , tab(3).head, tab(5).toInt)
    val input = new Input()

    board.fill_map()
    board.print()
    // Boucle de type C que j'aimerais plutot faire avec une expression
    while (true) {
      if (!run_my_game("p1", board, input, board._p1))
        return "Player 1 won !"
      if (!run_my_game("p2", board, input, board._p2))
        return "Player 2 won !"
    }
    "seriously, how did I get here?"
  }

  def main(args: Array[String]): Unit = {

    val turn = Try {
      args(0)
      args(2)
      args(4)
      args(5)
    }
    turn match {
      case Failure(_) =>
        println (s"${run_without_args()}")
        sys.exit(0)
      case Success(n) => if(!isAllDigits(n) || n.toInt <= 2 ||
        args.length > 6 || args(1).length > 1 || args(3).length > 1){
        System.err.println(usage)
        sys.exit(84)
    }
      }
    println (s"${run_with_args(args)}")
    sys.exit(0)
  }
}