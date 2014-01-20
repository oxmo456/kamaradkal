package controllers.api

import play.api.mvc._
import models.{DefaultLanguageRepository, LanguagesRepository}
import play.api.libs.json.Json

trait Languages {
  this: Controller =>

  def model: LanguagesRepository

  def select(id: Option[Int]) = Action {
    id match {
      case Some(id) => Ok(Json.toJson(s"Ok $id"))
      case None => Ok(Json.toJson("Oops"))
    }
  }

  def update(id: Int) = Action {
    Ok("ok")
  }

  def insert() = play.mvc.Results.TODO

  def delete(id: Int) = play.mvc.Results.TODO

}

object Languages extends Controller with Languages {
  def model: LanguagesRepository = DefaultLanguageRepository()
}


