package controllers

import models.Move
import models.Move._
import play.api.mvc.{Action, _}

class GameController() extends Controller with Logging {


  def index = Action {
    log.debug("Index called")
    Ok(views.html.index())
  }

  def randomMove() = Action {
    log.debug("Random Move")
    Ok(Move(scala.util.Random.nextInt(Move.maxId)).toString)
  }

  def resultForFirstPlayer(p1Move: String, p2Move: String) = Action {
    log.debug("ResultForFirstPlayer called")
    val mayBeFirstPlayerMove = Move.withNameOpt(p1Move)
    val mayBeSecondPlayerMove = Move.withNameOpt(p2Move)

    if (mayBeFirstPlayerMove.isEmpty || mayBeSecondPlayerMove.isEmpty) {
      BadRequest("Illegal moves")
    } else {
      val gameResult = moveCompare(mayBeFirstPlayerMove.get.asInstanceOf[Move.MoveValue], mayBeSecondPlayerMove.get.asInstanceOf[Move.MoveValue])
      Ok(gameResult.toString)
    }
  }

}
