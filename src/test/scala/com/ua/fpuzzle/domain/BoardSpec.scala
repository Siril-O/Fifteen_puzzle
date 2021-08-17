package com.ua.fpuzzle.domain

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpecLike

class BoardSpec extends AnyWordSpecLike {

  "Board" should {
    val solvedTiles = (0 to 3)
      .map(row =>
        (0 to 3).map(column => if (row == 3 && column == 3) None else Some(row * 4 + column + 1))
      )
    "confirm puzzle solved" in {
      val board = Board(solvedTiles)
      board.isPuzzleSolved shouldEqual true
      board.moveToEmpty(15)
      board.isPuzzleSolved shouldEqual false
    }

    "move tiles" in {
      val board = Board(solvedTiles)
      board.moveToEmpty(15)

      board.getTiles shouldEqual Seq(
        Seq(Some(1), Some(2), Some(3), Some(4)),
        Seq(Some(5), Some(6), Some(7), Some(8)),
        Seq(Some(9), Some(10), Some(11), Some(12)),
        Seq(Some(13), Some(14), None, Some(15))
      )
      board.moveToEmpty(11)
      board.getTiles shouldEqual Seq(
        Seq(Some(1), Some(2), Some(3), Some(4)),
        Seq(Some(5), Some(6), Some(7), Some(8)),
        Seq(Some(9), Some(10), None, Some(12)),
        Seq(Some(13), Some(14), Some(11), Some(15))
      )
      board.moveToEmpty(7)
      board.getTiles shouldEqual Seq(
        Seq(Some(1), Some(2), Some(3), Some(4)),
        Seq(Some(5), Some(6), None, Some(8)),
        Seq(Some(9), Some(10), Some(7), Some(12)),
        Seq(Some(13), Some(14), Some(11), Some(15))
      )
      board.moveToEmpty(3)
      board.getTiles shouldEqual Seq(
        Seq(Some(1), Some(2), None, Some(4)),
        Seq(Some(5), Some(6), Some(3), Some(8)),
        Seq(Some(9), Some(10), Some(7), Some(12)),
        Seq(Some(13), Some(14), Some(11), Some(15))
      )
      board.moveToEmpty(2)
      board.getTiles shouldEqual Seq(
        Seq(Some(1), None, Some(2), Some(4)),
        Seq(Some(5), Some(6), Some(3), Some(8)),
        Seq(Some(9), Some(10), Some(7), Some(12)),
        Seq(Some(13), Some(14), Some(11), Some(15))
      )
      board.moveToEmpty(1)
      board.getTiles shouldEqual Seq(
        Seq(None, Some(1), Some(2), Some(4)),
        Seq(Some(5), Some(6), Some(3), Some(8)),
        Seq(Some(9), Some(10), Some(7), Some(12)),
        Seq(Some(13), Some(14), Some(11), Some(15))
      )
      board.emptyTile shouldEqual Coord(0, 0)
    }
  }
}
