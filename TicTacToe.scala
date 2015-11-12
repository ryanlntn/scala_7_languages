object TicTacToe {
  val players = List('X', 'O')
  // val board = Array.fill(3,3)(' ')
  val board = Array(
    Array('X', ' ', 'X'),
    Array(' ', 'X', ' '),
    Array('X', ' ', ' ')
  )

  def evaluateBoard {
    // Check Rows
    board.foreach { row =>
      players.foreach { player =>
        if (row.forall(_ == player)) return winner(player)
      }
    }

    // Check Columns
    (0 until board.size).foreach { col =>
      players.foreach { player =>
        if (board.map(row => row(col)).forall(_ == player)) return winner(player)
      }
    }

    // Check Diagonals
    players.foreach { player =>
      if ((0 until board.size).map(i => board(i)(i)).forall(_ == player))              return winner(player)
      if ((0 until board.size).map(i => board(i)(board.size-1-i)).forall(_ == player)) return winner(player)
    }

    // If all else fails it's a draw
    println("It's a draw.")
  }

  def winner(name: Char) {
    println(s"${name} Wins!")
  }

  def main(args: Array[String]) {
    evaluateBoard
  }
}
