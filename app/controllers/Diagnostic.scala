package controllers

import play.api.mvc._

object Diagnostic extends Controller {

  def ping = Action {
    Ok(views.html.index("ok"))
  }

}