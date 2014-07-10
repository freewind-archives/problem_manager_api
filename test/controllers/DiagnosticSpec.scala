package controllers

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}
import play.api.libs.json._

@RunWith(classOf[JUnitRunner])
class DiagnosticSpec extends Specification {
  "Diagnostic" should {

    "render ok when visit ping" in new WithApplication {
      val ping = route(FakeRequest(GET, "/diagnostic/ping")).get

      status(ping) === OK
      contentAsString(ping) must contain("ok")
    }
    "render =Problem Manager Api= when visit name" in new WithApplication {
      val ping = route(FakeRequest(GET, "/diagnostic/name")).get

      status(ping) === OK
      contentAsString(ping) must contain("Problem Manager Api")
    }

    "return hello message when recieve a post request with json data" in new WithApplication {
      val hello = route(FakeRequest(POST, "/diagnostic/hello").withJsonBody(Json.parse( """{ "name": "value" }"""))).get

      status(hello) === OK
      contentType(hello) must beSome("application/json")
      contentAsJson(hello) mustEqual Json.obj("hello" -> "value")
    }
  }

}
