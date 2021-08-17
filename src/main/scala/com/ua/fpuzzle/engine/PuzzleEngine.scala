package com.ua.fpuzzle.engine

import com.ua.fpuzzle.domain.BoardGenerator
import com.ua.fpuzzle.view.{BoardView, InputReader}

case class PuzzleEngine(boardView: BoardView, inputReader: InputReader) {

  def play(): Unit = {
    val board = BoardGenerator.randomBoard()
    while (!board.isPuzzleSolved) {
      boardView.renderStatus(board)
      boardView.renderAvailableMoves(board)
      val nextCoordinates = inputReader.readNextMove(board.getAvailableTilesToMove)
      board.moveToEmpty(nextCoordinates)
    }
  }
}
