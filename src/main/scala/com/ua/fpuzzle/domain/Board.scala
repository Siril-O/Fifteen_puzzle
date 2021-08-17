package com.ua.fpuzzle.domain

import com.ua.fpuzzle.domain.Board._
import com.ua.fpuzzle.domain.Coord.isInRange

import scala.collection.mutable.{Seq => MSeq}

class Board(private val tiles: MSeq[MSeq[Tile]]) {

  require(tiles.size == Rows, s"Wrong amount of rows required 4 got ${tiles.size}")
  require(tiles.forall(_.size == TilesPerRow), s"Wrong amount of tiles in a row required 4 got ${tiles.size}")
  require(traverseMap((_, tile) => tile.value.isEmpty).count(identity) == 1, s"Only Singe tile should be empty")

  def getTiles: Seq[Seq[Tile]] = tiles.map(_.toSeq).toSeq

  def moveToEmpty(value: Int): Unit = {
    require(value > 0 && value <= maxTileValue, s"Tile number exceeds available ranges $maxTileValue")
    val current = traverseMap[(Coord, Tile)]((c, t) => c -> t).find(_._2.value.exists(_ == value)).map(_._1).get
    moveToEmpty(current)
  }

  def moveToEmpty(current: Coord): Unit = {
    require(availableTilesToMove.contains(current), "Move is invalid, can not be performed")
    val empty = emptyTile
    val currentNumber = tiles(current.x)(current.y)
    tiles(empty.x)(empty.y) = currentNumber
    tiles(current.x)(current.y) = Tile(None)
  }

  def emptyTile: Coord = traverseMap((c, tile) => c -> tile.value.isEmpty).find(_._2).head._1

  private def availableTilesToMove: Seq[Coord] = {
    Seq(
      (emptyTile.x, emptyTile.y - 1), (emptyTile.x, emptyTile.y + 1),
      (emptyTile.x - 1, emptyTile.y), (emptyTile.x + 1, emptyTile.y)
    ).filter(isInRange).map(Coord(_))
  }

  def getAvailableTilesToMove: Seq[Int] = {
    availableTilesToMove.flatMap(c => tiles(c.x)(c.y).value)
  }

  private def traverseMap[T](f: (Coord, Tile) => T): Iterator[T] =
    for {
      row <- RowsRange.iterator
      column <- TilesRange.iterator
    } yield f(Coord(row, column), tiles(row)(column))

  def isPuzzleSolved: Boolean = {
    def expectedTileValue(coord: Coord) = coord.x * 4 + (coord.y + 1)

    traverseMap((coord, tile) =>
      if (isLast(coord))
        tile.value.isEmpty
      else
        tile.value.contains(expectedTileValue(coord))
    )
      .forall(identity)
  }

  private def isLast(coord: Coord) =
    (coord.x == Rows - 1) && (coord.y == TilesPerRow - 1)

}

object Board {
  val Rows = 4
  val TilesPerRow = 4
  private val maxTileValue = Rows * TilesPerRow - 1
  val RowsRange: Range = 0 until Rows
  val TilesRange: Range = 0 until Rows

  def apply(tiles: Seq[Seq[Tile]]): Board = new Board(MSeq(tiles.map(MSeq(_: _*)): _*))

}

case class Coord(x: Int, y: Int) {
  require(isInRange(x, Rows), s"X is out of range $x")
  require(isInRange(y, TilesPerRow), s"Y is out of range $x")

}

object Coord {
  def apply(input: (Int, Int)): Coord = Coord(input._1, input._2)

  private def isInRange(input: Int, max: Int): Boolean = input < max && input >= 0

  def isInRange(input: (Int, Int)): Boolean = isInRange(input._1, Rows) && isInRange(input._2, TilesPerRow)

}