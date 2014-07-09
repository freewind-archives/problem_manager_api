package controllers

import play.api.mvc._
import play.api.libs.json._

object Diagnostic extends Controller {

  def ping: Action[AnyContent] = Action {
    Ok("ok")
  }

  def name: Action[AnyContent] = Action {
    Ok("Problem Manager Api")
  }

  def hello: Action[JsValue] = Action(BodyParsers.parse.json) { request =>
    val name = (request.body \ "name").asOpt[String]
    val response = Json.obj("hello" -> name)
    Ok(response)
  }

}