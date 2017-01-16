package controllers

import javax.inject._

import controllers.SwaggerController._
import play.api.Mode.Mode
import play.api.mvc._
import play.api.{Environment, Mode}
import swaggerblocks.rendering.playJson._

object SwaggerController {
  import swaggerblocks._
  import swaggerblocks.Implicits._

  def apiRoot(mode: Mode) = {
    val host =
      if (mode == Mode.Prod)
        "name.my.host"
      else
        "localhost:9000"

    swaggerRoot("2.0")(
      host = host,
      basePath = "/",
      info(
        version = "1.0",
        title = "$name$",
        description = "A play-scala project called $name$"
      )
    )
  }
}

@Singleton
class SwaggerController @Inject()(env: Environment) extends Controller {

  lazy val paths   = List.empty
  lazy val schemas = List.empty

  def json = Action {
    val swaggerJson: String = renderPretty(apiRoot(env.mode), paths, schemas)

    Ok(swaggerJson)
  }

  def index = Action { request =>
    Ok(views.html.swagger(request.path.replace("swagger", "swagger.json")))
  }

}
