package com.ua.fpuzzle.engine

import com.ua.fpuzzle.domain.Board
import com.ua.fpuzzle.view.{BoardView, InputReader}
import org.mockito.IdiomaticMockito.StubbingOps
import org.mockito.MockitoSugar.mock
import org.mockito.matchers.MacroBasedMatchers
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpecLike

class PuzzleEngineSpec extends AnyWordSpecLike with MacroBasedMatchers {

  private val inputReader = mock[InputReader]
  private val engine = PuzzleEngine(mock[BoardView], inputReader)
  "PuzzleEngine" should {
    "play game with single move" in {
      inputReader.readNextMove(*) shouldReturn 15
      val board = Board(Seq(
        Seq(Some(1), Some(2), Some(3), Some(4)),
        Seq(Some(5), Some(6), Some(7), Some(8)),
        Seq(Some(9), Some(10), Some(11), Some(12)),
        Seq(Some(13), Some(14), None, Some(15))
      ))
      board.isPuzzleSolved shouldEqual false
      engine.play(board)
      board.isPuzzleSolved shouldEqual true
    }
  }

}
