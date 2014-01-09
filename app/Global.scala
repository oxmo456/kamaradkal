import play.api.{Application, GlobalSettings}
import play.Logger

object Global extends GlobalSettings {

  override def onStart(app: Application) = {

    Logger.info("onStart...")


  }


}