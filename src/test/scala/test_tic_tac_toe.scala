import exercices.exercice_tic_tac_toe.{Board, Input, Main}
import org.scalatest.{FlatSpec, Matchers}

class test_tic_tac_toe extends FlatSpec with Matchers {
  "isAllDigits" should "return false if not digit" in {
    val str = Array("-p1","A","-p2","M","-s","eeeee")
    Main.isAllDigits("1-e156") shouldBe false
  }
  "check_format" should "check bad input format" in {
    val input = new Input()
    input.check_format("2;2") shouldBe false
    input.check_format("2,221") shouldBe false
    input.check_format("10,") shouldBe false
    input.check_format("3,4e") shouldBe false
  }
  "check_range" should "check bad range" in {
    val board = new Board()
    val input = new Input()

    board.fill_map()
    input.check_range("-1,8", board) shouldBe false
    input.check_range("0,1", board) shouldBe false
    input.check_range("1,5", board) shouldBe false
    input.check_range("8,3", board) shouldBe false
  }
  "main" should "check stdin input" in {
    //fail to test my main who parse std input args
    //Main.main((str)) shouldBe 84
  }
}
