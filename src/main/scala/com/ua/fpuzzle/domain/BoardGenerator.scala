package com.ua.fpuzzle.domain

import com.ua.fpuzzle.domain.Board.{Rows, RowsRange, TilesPerRow, TilesRange}

import scala.util.Random

object BoardGenerator {

  def randomBoard(rnd: Random = Random): Board = {
    val shuffled: Seq[Tile] = rnd.shuffle((1 until (Rows * TilesPerRow)).map(n => Tile(Some(n))).toList :+ Tile(None))
    Board(RowsRange.map(row => TilesRange.map(col => shuffled(row * Rows + col))))
  }

}
