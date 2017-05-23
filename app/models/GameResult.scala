package models

object GameResult extends Enumeration{
  type GameResult = Value
  val WIN = Value("WIN")
  val LOOSE = Value("LOOSE")
  val DRAW = Value("DRAW")
}
