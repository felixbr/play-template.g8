package helpers

import io.circe.Decoder
import io.circe.parser._
import org.scalatest.matchers.{MatchResult, Matcher}
import cats.syntax.either._

trait JsonMatchers {

  def beParsableAsJson =
    Matcher { (leftSideJsonString: String) =>
      val result = parse(leftSideJsonString)

      MatchResult(
        matches = result.isRight,
        s"The provided json is not parsable: \${result.left.toOption.getOrElse("")}",
        s"The provided json is parsable"
      )
    }

  def beParsableAs[A](implicit d: Decoder[A]) =
    Matcher { (leftSideJsonString: String) =>
      val result = decode[A](leftSideJsonString)

      MatchResult(
        matches = result.isRight,
        s"The provided json is not parsable: \${result.left.toOption.getOrElse("")}",
        s"The provided json is parsable"
      )
    }
}

// Make them easy to import with:
// import JsonMatchers._
object JsonMatchers extends JsonMatchers
