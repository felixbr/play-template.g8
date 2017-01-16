package util

import helpers.ProjectSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

class AppConfigSpec extends ProjectSpec with GuiceOneAppPerSuite {

  "The AppConfig" must {

    "be able to be instantiated" in {
      app.injector.instanceOf[AppConfig]
    }
  }
}
