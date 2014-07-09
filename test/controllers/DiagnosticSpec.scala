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
      contentType(ping) must beSome.which(_ == "text/html")
      contentAsString(ping) must contain ("ok")
    }
  }

}
