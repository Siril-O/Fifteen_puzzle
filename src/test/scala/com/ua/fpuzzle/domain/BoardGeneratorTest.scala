package com.ua.fpuzzle.domain

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpecLike

class BoardGeneratorTest extends AnyWordSpecLike {

  "BoardGenerator" should {
    "generate valid random board" in {
      val generated = BoardGenerator.randomBoard()
      val tiles = generated.getTiles
      tiles.size shouldEqual 4
      tiles.foreach(_.size shouldEqual 4)
      tiles.flatten.count(_.isEmpty) shouldBe 1
      tiles.flatten.collect { case Some(v) => v }.sorted shouldBe (1 to 15)
    }

  }
}