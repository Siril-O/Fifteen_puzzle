package com.ua.fpuzzle.domain

import com.ua.fpuzzle.domain.Board._

import scala.util.Random

object BoardGenerator {

  def randomBoard(rnd: Random = Random): Board = {
    val allTiles = (1 until (Rows * TilesPerRow)).map(n => Some(n)).toList :+ None
    val shuffled: Seq[Tile] = rnd.shuffle(allTiles)
    Board(RowsRange.map(row => TilesRange.map(col => shuffled(row * Rows + col))))
  }

}
