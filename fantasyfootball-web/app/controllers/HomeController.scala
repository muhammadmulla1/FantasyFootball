package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index("Welcome to Fantasy Football!"))
  }


  def hello = Action {
    Ok("Hello, Fantasy Football!")
  }

  def greet(name: String) = Action {
    Ok(views.html.hello(name))
  }

}
