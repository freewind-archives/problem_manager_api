package controllers

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}
import play.api.libs.json._
import scalax.io._
import scalax.file.Path

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

    "return build version when build version file exists" in new WithApplication {
      cleanUpFile
      Resource.fromFile("build_version").write("1.0.0")
      val versionResp = route(FakeRequest(GET, "/diagnostic/version")).get

      status(versionResp) === OK
      contentAsString(versionResp) === "1.0.0"
      cleanUpFile
    }

    "return unknown when build version file does notexists" in new WithApplication {
      cleanUpFile
      val versionResp = route(FakeRequest(GET, "/diagnostic/version")).get

      status(versionResp) === OK
      contentAsString(versionResp) === "unknown"
    }

    "return hello message when recieve a post request with json data" in new WithApplication {
      val hello = route(FakeRequest(POST, "/diagnostic/hello").withJsonBody(Json.parse( """{ "name": "value" }"""))).get

      status(hello) === OK
      contentType(hello) must beSome("application/json")
      contentAsJson(hello) mustEqual Json.obj("hello" -> "value")
    }
  }

  private def cleanUpFile = Path("build_version").deleteIfExists()

}
