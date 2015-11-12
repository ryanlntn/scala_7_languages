object TicTacToe {
  val players = List('X', 'O')
  // val board = Array.fill(3,3)(' ')
  val board = Array(
    Array('X', ' ', 'X'),
    Array(' ', ' ', ' '),
    Array('X', ' ', 'X')
  )
  val boardRange = (0 until board.size)

  def evaluateBoard {
    // Check Rows
    board.foreach(row => if (isWinner(row)) return)

    // Check Columns
    boardRange.foreach(col => if (isWinner(board.map(row => row(col)))) return)

    // Check Diagonals
    if (isWinner(boardRange.map(i => board(i)(i)))) return
    if (isWinner(boardRange.map(i => board(i)(board.size-1-i)))) return

    // If all else fails it's a draw
    println("It's a draw.")
  }

  def isWinner(collection: IndexedSeq[Char]): Boolean = {
    players.foreach { player =>
      if (collection.forall(_ == player)) {
        println(s"${player} Wins!")
        return true
      }
    }
    false
  }

  def main(args: Array[String]) {
    evaluateBoard
  }
}
