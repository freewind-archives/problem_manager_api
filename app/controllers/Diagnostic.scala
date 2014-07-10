package controllers

import play.api.mvc._
import play.api.libs.json._
import scala.io.Source.fromFile
import java.nio.file.{Paths, Files}

object Diagnostic extends Controller {

  val BUILD_VERSION_FILE = "build_version"

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

  def version: Action[AnyContent] = Action {
    Ok(readVersionOrElse("unknown"))
  }

  private def readVersionOrElse(alternative: String): String = {
    if (Files.exists(Paths.get(BUILD_VERSION_FILE))) {
      fromFile(BUILD_VERSION_FILE).mkString
    } else {
      alternative
    }
  }
}