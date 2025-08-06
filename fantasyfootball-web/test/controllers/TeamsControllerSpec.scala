package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test._
import play.api.test.Helpers._

class TeamsControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "TeamsController GET /teams" should {
    "render the list of teams" in {
      val request = FakeRequest(GET, "/teams")
      val controller = inject[TeamsController]
      val result = controller.list().apply(request)

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("Premier League Teams for 2025/26 Season")
    }
  }

  "TeamsController GET /teams/:id" should {
    "show the team if ID exists" in {
      val request = FakeRequest(GET, "/teams/1")
      val controller = inject[TeamsController]
      val result = controller.show(1).apply(request)

      status(result) mustBe OK
      contentAsString(result) must include ("AFC Bournemouth")
    }

    "return 404 if team is not found" in {
      val request = FakeRequest(GET, "/teams/999")
      val controller = inject[TeamsController]
      val result = controller.show(999).apply(request)

      status(result) mustBe NOT_FOUND
    }
  }
}
