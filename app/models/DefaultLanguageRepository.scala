package models

object DefaultLanguageRepository {

  def apply(): DefaultLanguageRepository = new DefaultLanguageRepository()

}

class DefaultLanguageRepository extends LanguagesRepository {

}
