package controllers

import javax.inject._
import play.api.mvc._
import models.Team

@Singleton
class TeamsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val teams = List(
    Team(1044, "AFC Bournemouth", "bournemouth.png"),
    Team(57, "Arsenal", "arsenal.png"),
    Team(58, "Aston Villa", "astonvilla.png"),
    Team(402, "Brentford", "brentford.png"),
    Team(397, "Brighton & Hove Albion", "brighton.png"),
    Team(328, "Burnley", "burnley.png"),
    Team(61, "Chelsea", "chelsea.png"),
    Team(354, "Crystal Palace", "crystalpalace.png"),
    Team(62, "Everton", "everton.png"),
    Team(63, "Fulham", "fulham.png"),
    Team(341, "Leeds United", "leeds.png"),
    Team(64, "Liverpool", "liverpool.png"),
    Team(65, "Manchester City", "mancity.png"),
    Team(66, "Manchester United", "manutd.png"),
    Team(67, "Newcastle United", "newcastle.png"),
    Team(351, "Nottingham Forest", "nottingham.png"),
    Team(71, "Sunderland", "sunderland.png"),
    Team(73, "Tottenham Hotspur", "tottenham.png"),
    Team(563, "West Ham United", "westham.png"),
    Team(76, "Wolverhampton Wanderers", "wolves.png")
  )

  def list() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.teams(teams))
  }

  def show(id: Int) = Action { implicit request: Request[AnyContent] =>
    teams.find(_.id == id) match {
      case Some(team) => Ok(views.html.teamDetail(team))
      case None => NotFound("Team not found")
    }
  }
}
