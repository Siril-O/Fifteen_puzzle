package com.ua.fpuzzle

import com.ua.fpuzzle.engine.PuzzleEngine
import com.ua.fpuzzle.view.console.{ConsoleBoardView, ConsoleInputReader}

object Start {

  def main(args: Array[String]): Unit = {
    println("Welcome to puzzle game.")
    PuzzleEngine(ConsoleBoardView, ConsoleInputReader).play()
    println("Welcome you won. See you next time")

  }
}
