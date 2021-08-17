package com.ua.fpuzzle.view.console

import com.ua.fpuzzle.domain.Board
import com.ua.fpuzzle.domain.Board.Tile
import com.ua.fpuzzle.view.BoardView

object ConsoleBoardView extends BoardView {

  override type OUTPUT = Unit

  override def renderStatus(board: Board): Unit = {
    println("Currently board looks like this:")
    println(board.getTiles.map(formatRow).mkString(s"${renderBoardLines()}\n", "\n", s"\n${renderBoardLines(false)}"))
  }

  private def renderBoardLines(top: Boolean = true): String = (if (top) "-" else "_") * 20

  private def formatTile(t: Tile): String = t.fold("X ")(v => f"$v%2d")

  private def formatRow(row: Seq[Tile]): String = row.map(formatTile).mkString("|", " | ", "|")

  override def renderAvailableMoves(board: Board): Unit = {
    println("Available numbers to moves to empty tile:")
    println(board.getAvailableTilesToMove.mkString(","))
    println("Press tile number to move it:")
  }
}
