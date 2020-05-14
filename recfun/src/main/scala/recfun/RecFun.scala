package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c > r || c < 0) 0
    else if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */

  // test cases: '', '()', '(())', '(()', '())', ')()'
  def balance(chars: List[Char]): Boolean = {
    @scala.annotation.tailrec
    def balanceHelper(count: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) count == 0
      else if (count < 0)
        false
      else {
        val increment =
          if (chars.head == '(') 1
          else if (chars.head == ')') -1
          else 0

        balanceHelper(count + increment, chars.tail)
      }
    }

    balanceHelper(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    @scala.annotation.tailrec
    def countChangeHelper(count: Int, denominations: List[Int]): Int =
      if (denominations.isEmpty) count
      else {
        val increment = countChange(money - denominations.head, coins)
        countChangeHelper(count + increment, denominations.tail)
      }

    if (money == 0) 1
    else if (money < 0) 0
    else countChangeHelper(0, coins)
  }
}
