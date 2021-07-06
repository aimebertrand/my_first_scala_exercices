package exercices.exercice_tic_tac_toe


import scala.util.{Success, Failure, Try}

class Board(p1: Char, p2: Char, size: Int) {
  def this() = {
    this('X', 'O', 3)
  }
  def this(p1: Char, p2: Char) = {
    this(p1, p2, 3)
  }
  def this(size: Int) = {
    this('X', '0', size)
  }

  def fill_map(): Unit = {
    //encore une fonction de type C que j'aimerais améliorer
    for (i <- _map.indices; j <- _map(0).indices) {
      _map(i)(j) =
        if ((i == 0 && j == 0) || i == _map.length - 1 && j == 0 || j == _map(0).length - 1 && i == 0
          || i == _map.length - 1 && j == _map(0).length - 1) '+'
        else if  (i == 0 || i == _map.length-1 ) '-'
        else if  (j == 0 || j == _map(0).length-1) '|'
        else ' '
    }
  }

  def update(tab : Array[String], p1 : Option [Char], p2 : Option [Char]) : Unit = {
      _map(tab(0).toInt)(tab(1).toInt) = p2.getOrElse(p1.get)
  }

  def print(): Unit = {
    for (i <- _map.indices) {
      var line: String = ""
      for (j <- _map(0).indices) {
        line += _map(i)(j)
      }
      println(line)
    }
  }


  def did_won(x: Int, y: Int): Boolean = {

    if (dig_left_move() == IndexedSeq(_p1, _p1, _p1) || dig_left_move() == IndexedSeq(_p2, _p2, _p2))  {true}
    else if (dig_right_move() == IndexedSeq(_p1, _p1, _p1) || dig_right_move() == IndexedSeq(_p2, _p2, _p2))  {true}
    else if (vert_move(y) == IndexedSeq(_p1, _p1, _p1) || vert_move(y) == IndexedSeq(_p2, _p2, _p2))  {true}
    else if (horizon_move(y) == IndexedSeq(_p1, _p1, _p1) || horizon_move(y) == IndexedSeq(_p2, _p2, _p2))  {true}
    else
      false

    // Une mauvaise utilisation du Try - match ??
     /* val res = Try {
        dig_left_move()
        dig_right_move()
        vert_move(y)
        horizon_move(x)
      }
      res match {
        case Success(value) =>
          println("value == ", value)
          if ((value == IndexedSeq(_p1, _p1, _p1)) || value == IndexedSeq(_p2, _p2, _p2)) false
      else true
        case Failure(_) => false
      }*/
    }

  private def vert_move(y: Int, x: Int = 1): IndexedSeq[Char] = {
    for (xs <- x until _map.length - 1) yield _map(xs)(y)
  }
  private def horizon_move(x: Int, y: Int = 1): IndexedSeq[Char] = {
    for (ys <- y until _map.length - 1) yield _map(x)(ys)
  }
  private def dig_right_move(x: Int = 1, y: Int = 1): IndexedSeq[Char] = {
    for ((xs, ys) <- (x until _map.length - 1) zip (y until _map.length - 1)) yield _map(xs)(ys)
  }
  private def dig_left_move(x: Int = _map.length - 2, y: Int = 1): IndexedSeq[Char] = {
    for ((xs, ys) <- (x until 0 by -1) zip (y until _map.length - 1)) yield _map(xs)(ys)
  }
  val _p1 : Char = p1
  val _p2 : Char = p2
  var _map: Array[Array[Char]] = Array.ofDim[Char](size + 2, size + 2)
}
