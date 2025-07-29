package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class TeamsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def list() = Action {
    val teams = List(
      "AFC Bournemouth",
      "Arsenal",
      "Aston Villa",
      "Brentford",
      "Brighton & Hove Albion",
      "Burnley",
      "Chelsea",
      "Crystal Palace",
      "Everton",
      "Fulham",
      "Leeds",
      "Liverpool",
      "Manchester City",
      "Manchester United",
      "Newcastle United",
      "Nottingham Forest",
      "Sunderland",
      "Tottenham Hotspur",
      "West Ham United",
      "Wolverhampton Wanderers"
    )
    Ok(views.html.teams(teams))
  }
}
