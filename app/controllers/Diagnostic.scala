package controllers

import play.api.mvc._

object Diagnostic extends Controller {

  def ping = Action {
    Ok("ok")
  }
}