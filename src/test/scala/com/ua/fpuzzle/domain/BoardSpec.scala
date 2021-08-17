package com.ua.fpuzzle.domain

import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.matchers.should.Matchers._

import scala.util.Random

class BoardSpec extends AnyWordSpecLike {

  "Board" should {
    "confirm puzzle solved" in {
      val tiles = (0 to 3)
        .map(row =>
          (0 to 3).map(column => Tile(if (row == 3 && column == 3) None else Some(row * 4 + column + 1)))
        )
      println(tiles.map(_.mkString(",")).mkString("\n"))
      Board(tiles).isPuzzleSolved shouldEqual true
    }

    "bla"in {
      val t = BoardGenerator.randomBoard(Random).getTiles
      println(t.map(_.mkString(",")).mkString("\n"))
    }
  }
}
