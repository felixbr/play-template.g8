package helpers

import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import play.api.test.DefaultAwaitTimeout

trait ProjectSpec extends PlaySpec with ScalaFutures with DefaultAwaitTimeout with JsonMatchers
