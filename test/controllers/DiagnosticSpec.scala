package controllers

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

@RunWith(classOf[JUnitRunner])
class DiagnosticSpec extends Specification {
  "Diagnostic" should {

    "render ok when visit ping" in new WithApplication{
      val ping = route(FakeRequest(GET, "/diagnostic/ping")).get

      status(ping) must equalTo(OK)
      contentAsString(ping) must contain ("ok")
    }
    "render =Problem Manager Api= when visit name" in new WithApplication{
      val ping = route(FakeRequest(GET, "/diagnostic/name")).get

      status(ping) must equalTo(OK)
      contentAsString(ping) must contain ("Problem Manager Api")
    }
  }

}
