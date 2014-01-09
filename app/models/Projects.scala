package models

case class Project(id: Int, name: String, description: String, language: Language)

case class Foo()

object Projects {

  def all(): List[Project] = Nil

  def insert(project: Project) {

  }

  def update(project: Project) {

  }

  def delete(project: Project) {

  }

}
