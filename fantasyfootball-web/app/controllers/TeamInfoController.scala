package controllers

import javax.inject._
import play.api.libs.ws._
import play.api.mvc._
import play.api.Configuration
import scala.concurrent.{ExecutionContext, Future}
import play.api.libs.json._

@Singleton
class TeamInfoController @Inject()(
                                    ws: WSClient,
                                    config: Configuration,
                                    val controllerComponents: ControllerComponents
                                  )(implicit ec: ExecutionContext) extends BaseController {

  private val apiKey: String = config.get[String]("football-data.api.key")
  private val baseUrl: String = config.get[String]("football-data.api.baseUrl")

  def teamDetails(id: Int) = Action.async { implicit request =>
    val url = s"$baseUrl/teams/$id"

    ws.url(url)
      .addHttpHeaders("X-Auth-Token" -> apiKey)
      .get()
      .map { response =>
        val json = response.json

        val name = (json \ "name").as[String]
        val crest = (json \ "crest").as[String]
        val founded = (json \ "founded").asOpt[Int].getOrElse(0)
        val clubColors = (json \ "clubColors").asOpt[String].getOrElse("Unknown")
        val venue = (json \ "venue").asOpt[String].getOrElse("Unknown")

        val squad = (json \ "squad").as[Seq[JsValue]].map { player =>
          (
            (player \ "name").as[String],
            (player \ "position").asOpt[String].getOrElse("Unknown"),
            (player \ "nationality").asOpt[String].getOrElse("Unknown")
          )
        }

        Ok(views.html.teamApiDetail(name, crest, founded, clubColors, venue, squad))
      }
  }
}
