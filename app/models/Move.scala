package models

import models.GameResult.GameResult

object Move extends Enumeration {

  def moveCompare(move1: Move, move2: Move): GameResult = {
    if (move1 == move2)
      return GameResult.DRAW
    if (move1.weaknesses.contains(move2.value)) {
      return GameResult.LOOSE
    }
    GameResult.WIN
  }

  def withNameOpt(s: String): Option[Value] = values.find(_.toString == s)

  case class MoveValue(value: String, weaknesses: Seq[String]) extends Val(value)

  type Move = MoveValue
  val ROCK = MoveValue("ROCK", Seq[String]("PAPER"))
  val PAPER = MoveValue("PAPER", Seq[String]("SCISSORS"))
  val SCISSORS = MoveValue("SCISSORS", Seq[String]("ROCK"))

  def moveWithName(name: String): MoveValue = {
    super.withName(name).asInstanceOf[MoveValue]
  }

}
