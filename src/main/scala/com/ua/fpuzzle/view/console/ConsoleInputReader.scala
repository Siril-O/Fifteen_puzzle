package com.ua.fpuzzle.view.console

import com.ua.fpuzzle.view.InputReader

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object ConsoleInputReader extends InputReader {

  private val DigitRegexp = """(\d+)""".r

  @tailrec
  override def readNextMove(available: Seq[Int]): Int = {
    val input = readLine("Enter single number> ")
    input.trim match {
      case DigitRegexp(digit) if available.contains(digit.toInt) => digit.toInt
      case DigitRegexp(digit) =>
        println(s"Wrong input $digit, expected one of '${available.mkString(",")}'")
        readNextMove(available)
      case _ =>
        println("Wrong input, expected single number")
        readNextMove(available)
    }


  }
}
