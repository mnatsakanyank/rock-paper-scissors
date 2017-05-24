package models

import models.GameResult._

object Move extends Enumeration {

  def moveCompare(move1: Move, move2: Move): GameResult = {
    (move1, move2) match {
      case (first, second) if first == second => GameResult.DRAW
      case (first, second) if first.weaknesses.contains(second.value) => LOOSE
      case _ => WIN
    }
  }

  def withNameOpt(s: String): Option[MoveValue] = values.map(_.asInstanceOf[MoveValue]).find(_.toString == s).map(_.asInstanceOf[MoveValue])

  case class MoveValue(value: String, weaknesses: Seq[String]) extends Val(value)

  type Move = MoveValue
  val ROCK = MoveValue("ROCK", Seq[String]("PAPER"))
  val PAPER = MoveValue("PAPER", Seq[String]("SCISSORS"))
  val SCISSORS = MoveValue("SCISSORS", Seq[String]("ROCK"))

  def moveWithName(name: String): MoveValue = {
    super.withName(name).asInstanceOf[MoveValue]
  }

}
