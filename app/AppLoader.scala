import play.api.ApplicationLoader.Context
import play.api.cache.EhCacheComponents
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api._
import play.filters.gzip.GzipFilter
import router.Routes

class AppLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach(_.configure(context.environment))
    new AppComponents(context).application
  }
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context) with EhCacheComponents {

  lazy val gameController = new controllers.GameController()
  lazy val jsRouts = new controllers.JsRoutes(defaultCacheApi)
  lazy val assets = new controllers.Assets(httpErrorHandler)

  // Routes is a generated class
  override def router: Router = new Routes(
    httpErrorHandler,
    gameController,
    jsRouts,
    assets
  ).withPrefix(httpConfiguration.context)

  val gzipFilter = new GzipFilter(shouldGzip =
    (request, response) => {
      val contentType = response.header.headers.get("Content-Type")
      contentType.exists(_.startsWith("text/html")) || request.path.endsWith("jsroutes.js")
    })

  override lazy val httpFilters: Seq[EssentialFilter] = Seq(gzipFilter)
}
