package controllers.api

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.{SimpleResult, Controller}
import models.LanguagesRepository
import scala.concurrent.Future
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
class LanguagesSpec extends Specification {


  "Languages" should {


    "select A" in new Context {
      val result: Future[SimpleResult] = languages.select(None).apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText must be equalTo "Oops"
    }

    "select B" in new Context {
      val id = 789
      val result: Future[SimpleResult] = languages.select(Some(id)).apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText must be equalTo s"Ok $id"
    }

  }

}

trait Context extends Scope {

  class Target() extends Controller with Languages {
    def model: LanguagesRepository = new LanguagesRepository {

    }
  }

  lazy val languages = new Target()


}
