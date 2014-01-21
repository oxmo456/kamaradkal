package controllers.api

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.{SimpleResult, Controller}
import models.{Language, LanguagesRepository}
import scala.concurrent.Future
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class LanguagesSpec extends Specification {

  "Languages.select" should {

    "select A" in new Context {
      val result: Future[SimpleResult] = languages.select(None).apply(FakeRequest())
      status(result) must equalTo(OK)
      contentType(result) must beSome("application/json")
      charset(result) must beSome("utf-8")
      contentAsJson(result).asOpt[String] must beSome("Oops")
    }

    "select B" in new Context {
      val id = 789
      val result: Future[SimpleResult] = languages.select(Some(id)).apply(FakeRequest())
      status(result) must equalTo(OK)
      contentType(result) must beSome("application/json")
      charset(result) must beSome("utf-8")
      contentAsJson(result).asOpt[String] must beSome("Ok " + id)
    }


  }

}

trait Context extends Scope {

  class Target() extends Controller with Languages {
    def model: LanguagesRepository = new LanguagesRepository {
      def selectAll(): List[Language] = List(
        Language(0, "fr"),
        Language(1, "en")
      )
    }
  }

  lazy val languages = new Target()


}
