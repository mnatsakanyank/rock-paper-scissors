package controllers


import models.Move
import org.scalatestplus.play._
import play.api.libs.json.{JsString, JsValue}
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future
/**
  * Created by karen.mnatsakanyan on 23/05/2017.
  */
class GameControllerTest extends PlaySpec with Results {

  "GameController index" in {
      val controller = new GameController()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      status(result) mustBe OK
      contentType(result).get mustBe "text/html"
  }


  "GameController randomMove" in {
    val controller = new GameController()
    val result: Future[Result] = controller.randomMove().apply(FakeRequest())
    status(result) mustBe OK
    contentType(result).get mustBe "text/plain"
    val content = contentAsString(result)
    Move.withName(content)
  }

  "GameController resultForFirstPlayer should be LOOSE" in {
    val controller = new GameController()
    val result: Future[Result] = controller.resultForFirstPlayer("ROCK","PAPER").apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    status(result) mustBe OK
    contentType(result).get mustBe "text/plain"
    contentAsString(result) mustBe "LOOSE"
  }

  "GameController resultForFirstPlayer should be DRAW" in {
    val controller = new GameController()
    val result: Future[Result] = controller.resultForFirstPlayer("ROCK","ROCK").apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    status(result) mustBe OK
    contentType(result).get mustBe "text/plain"
    contentAsString(result) mustBe "DRAW"
  }

  "GameController resultForFirstPlayer should be WIN" in {
    val controller = new GameController()
    val result: Future[Result] = controller.resultForFirstPlayer("ROCK","SCISSORS").apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    status(result) mustBe OK
    contentType(result).get mustBe "text/plain"
    contentAsString(result) mustBe "WIN"
  }


  "GameController resultForFirstPlayer should be BAD_REQUEST" in {
    val controller = new GameController()
    val result: Future[Result] = controller.resultForFirstPlayer("ROCK","rocky balboa").apply(FakeRequest())
    val bodyText: String = contentAsString(result)
    status(result) mustBe BAD_REQUEST
    contentType(result).get mustBe "text/plain"
    contentAsString(result) mustBe "Illegal moves"
  }
}
