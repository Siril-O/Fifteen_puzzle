package com.ua.fpuzzle.view

import com.ua.fpuzzle.domain.Coord

trait InputReader {

  def readNextMove(available: Seq[Int]): Int

}
