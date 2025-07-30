package controllers

import javax.inject._
import play.api.mvc._
import models.Team

@Singleton
class TeamsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val teams = List(
    Team(1, "AFC Bournemouth", "bournemouth.png"),
    Team(2, "Arsenal", "arsenal.png"),
    Team(3, "Aston Villa", "astonvilla.png"),
    Team(4, "Brentford", "brentford.png"),
    Team(5, "Brighton & Hove Albion", "brighton.png"),
    Team(6, "Burnley", "burnley.png"),
    Team(7, "Chelsea", "chelsea.png"),
    Team(8, "Crystal Palace", "crystalpalace.png"),
    Team(9, "Everton", "everton.png"),
    Team(10, "Fulham", "fulham.png"),
    Team(11, "Leeds", "leeds.png"),
    Team(12, "Liverpool", "liverpool.png"),
    Team(13, "Manchester City", "mancity.png"),
    Team(14, "Manchester United", "manutd.png"),
    Team(15, "Newcastle United", "newcastle.png"),
    Team(16, "Nottingham Forest", "nottingham.png"),
    Team(17, "Sunderland", "sunderland.png"),
    Team(18, "Tottenham Hotspur", "tottenham.png"),
    Team(19, "West Ham United", "westham.png"),
    Team(20, "Wolverhampton Wanderers", "wolves.png")
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
