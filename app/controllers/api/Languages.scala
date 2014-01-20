package controllers.api

import play.api.mvc._
import models.{DefaultLanguageRepository, LanguagesRepository}

trait Languages {
  this: Controller =>

  def model: LanguagesRepository

  def select(id: Option[Int]) = Action {
    Ok("ok")
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


