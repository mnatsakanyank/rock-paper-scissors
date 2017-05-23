package models

import org.scalatest._

/**
  * Created by karen.mnatsakanyan on 24/05/2017.
  */
class MoveTest extends FlatSpec {

  "A moveCompare PAPER with ROCK" should "return WIN " in {
    val rs = Move.moveCompare(Move.PAPER, Move.ROCK)
    assert(rs == GameResult.WIN)
  }

  "A moveCompare PAPER with SCISSORS" should "return LOOSE " in {
    val rs = Move.moveCompare(Move.PAPER, Move.SCISSORS)
    assert(rs == GameResult.LOOSE)
  }

  "A moveCompare PAPER with PAPER" should "return DRAW " in {
    val rs = Move.moveCompare(Move.PAPER, Move.PAPER)
    assert(rs == GameResult.DRAW)
  }

  "A moveCompare ROCK with SCISSORS" should "return WIN " in {
    val rs = Move.moveCompare(Move.ROCK, Move.SCISSORS)
    assert(rs == GameResult.WIN)
  }

  "A moveCompare ROCK with PAPER" should "return LOOSE " in {
    val rs = Move.moveCompare(Move.ROCK, Move.PAPER)
    assert(rs == GameResult.LOOSE)
  }

  "A moveCompare ROCK with ROCK" should "return DRAW " in {
    val rs = Move.moveCompare(Move.ROCK, Move.ROCK)
    assert(rs == GameResult.DRAW)
  }

  "A moveCompare SCISSORS with PAPER" should "return WIN " in {
    val rs = Move.moveCompare(Move.SCISSORS, Move.PAPER)
    assert(rs == GameResult.WIN)
  }

  "A moveCompare SCISSORS with ROCK" should "return LOOSE " in {
    val rs = Move.moveCompare(Move.SCISSORS, Move.ROCK)
    assert(rs == GameResult.LOOSE)
  }

  "A moveCompare SCISSORS with SCISSORS" should "return DRAW " in {
    val rs = Move.moveCompare(Move.SCISSORS, Move.SCISSORS)
    assert(rs == GameResult.DRAW)
  }

  "A withNameOpt SCISSORS" should "return SCISSORS " in {
    val rs = Move.withNameOpt("SCISSORS")
    assert(rs.isDefined)
    assert(rs.get == Move.SCISSORS)
  }

  "A withNameOpt ROCK" should "return ROCK " in {
    val rs = Move.withNameOpt("ROCK")
    assert(rs.isDefined)
    assert(rs.get == Move.ROCK)
  }

  "A withNameOpt PAPER" should "return PAPER " in {
    val rs = Move.withNameOpt("PAPER")
    assert(rs.isDefined)
    assert(rs.get == Move.PAPER)
  }

  "A withNameOpt ROCKY_BALBOA" should "return Empty Option " in {
    val rs = Move.withNameOpt("ROCKY_BALBOA")
    assert(rs.isEmpty)
  }
}
