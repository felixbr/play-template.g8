import helpers.ProjectSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.Helpers._
import play.api.test._

/**
  * Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  * For more information, consult the wiki.
  */
class ApplicationSpec extends ProjectSpec with GuiceOneAppPerSuite {

  "Routes" must {

    "send 303 see other on root request" in {
      route(app, FakeRequest(GET, "/")).map(s => status(s)) mustBe Some(SEE_OTHER)
    }
  }
}
