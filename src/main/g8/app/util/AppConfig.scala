package util

import javax.inject._

import play.api.Configuration
import pureconfig._
import util.AppConfig._

object AppConfig {

  case class App()

}

@Singleton
class AppConfig @Inject()(cfg: Configuration) {
  val app = loadConfig[App](cfg.underlying, "app").get
}
