package models


case class Language(id: Int, code: String)

trait LanguagesRepository {

  def selectAll(): List[Language]

}









