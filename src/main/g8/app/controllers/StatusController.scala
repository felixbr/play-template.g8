package controllers

import javax.inject._

import io.circe.generic.auto._
import io.circe.syntax._
import play.api.Environment
import play.api.mvc._
import play.api.libs.circe.Circe

import play.api.libs.concurrent.Execution.Implicits._

@Singleton
class StatusController @Inject()(env: Environment) extends Controller with Circe {

  case class StatusBody(
    status: String,
    mode: String
  )

  def index = Action {
    Ok(
      StatusBody(status = "ok", mode = env.mode.toString).asJson
    )
  }
}
