package com.ua.fpuzzle.view

import com.ua.fpuzzle.domain.Board

trait BoardView {
  type T

  def renderStatus(board: Board): T

  def renderAvailableMoves(board: Board): T

}
