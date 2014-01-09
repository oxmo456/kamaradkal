package controllers.api

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class LanguagesSpec extends Specification {


  "Languages" should {

    "select" in new WithApplication {

      val response = route(FakeRequest(GET, "/api/languages")).get
      status(response) must equalTo(OK)
      contentType(response) must beSome("application/json")
      charset(response) must beSome("utf-8")
      contentAsString(response) must equalTo("\"not found...\"")

    }


  }

}
