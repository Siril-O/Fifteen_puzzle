package com.ua.fpuzzle.view

trait InputReader {

  def readNextMove(available: Seq[Int]): Int

}
