package controllers

import play.api.cache._
import play.api.mvc.{Action, _}
import play.api.routing.JavaScriptReverseRoute

import scala.concurrent.duration._

class JsRoutes(val cache: CacheApi) extends Controller  {

  val cacheDuration = 1.day

  def Caching(key: String, okDuration: Duration) =
    new Cached(cache)
      .status(_ => key, OK, okDuration.toSeconds.toInt)
      .includeStatus(NOT_FOUND, 5.minutes.toSeconds.toInt)

  val routeCache: Seq[JavaScriptReverseRoute] = {
    val jsRoutesClasses = Seq(classOf[routes.javascript])
    jsRoutesClasses.flatMap { jsRoutesClass =>
      val controllers = jsRoutesClass.getFields.map(_.get(null))
      controllers.flatMap { controller =>
        controller.getClass.getDeclaredMethods.filter(_.getName != "_defaultPrefix").map { action =>
          action.invoke(controller).asInstanceOf[play.api.routing.JavaScriptReverseRoute]
        }
      }
    }
  }

  def jsRoutes(varName: String = "jsRoutes") = Caching("jsRoutes", cacheDuration) {
    Action { implicit request =>
      Ok(play.api.routing.JavaScriptReverseRouter(varName)(routeCache: _*)).as(JAVASCRIPT)
    }
  }


}
