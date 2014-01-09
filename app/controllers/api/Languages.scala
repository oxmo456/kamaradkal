package controllers.api

import play.api.mvc.{Action, Controller}
import play.api.libs.json.Json
import models.{DefaultLanguageRepository, LanguagesRepository}

class Languages(model: LanguagesRepository) extends Controller {

  def select(id: Option[Int]) = Action {

    id match {
      case Some(id) => Ok(Json.toJson(s"found $id"))
      case None => Ok(Json.toJson(s"not found..."))
    }

  }

  def update(id: Int) = play.mvc.Results.TODO

  def insert() = play.mvc.Results.TODO

  def delete(id: Int) = play.mvc.Results.TODO

}

object Languages extends Languages(DefaultLanguageRepository())
