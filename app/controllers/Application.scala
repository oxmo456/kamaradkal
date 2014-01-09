package controllers

import play.api.Play.current
import play.api.mvc._
import play.api.db.DB

object Application extends Controller {

  def index = Action {

    val projectsDefault: List[(Int, String)] = DB.withConnection {
      implicit c => Nil

    }



    Ok(views.html.index("projects", projectsDefault))
  }

  def get(id: Option[Int]) = Action {


    Ok("...")

  }

  //http://stackoverflow.com/questions/13189095/play-framework2-remove-trailing-slash-from-urls
  def untrail(path: String) = Action {
    MovedPermanently("/" + path)
  }


}