package com.ua.fpuzzle.view

import com.ua.fpuzzle.domain.Board

trait BoardView {
  type OUTPUT

  def renderStatus(board: Board): OUTPUT

  def renderAvailableMoves(board: Board): OUTPUT

}
