

package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json
import repo._

@Singleton
class ApiController @Inject()(cc: ControllerComponents)
extends AbstractController(cc)
{


   def ping = Action{ implicit request=>
      Ok("Hello From Scala")
   }


   def getComments(postId: Int)= Action { implicit request=>
      Ok(Json.toJson(DataRepository.getComments(postId)))
   }

   def getPosts(postId: Int)= Action { implicit request=>
      DataRepository.getPosts(postId) map { post =>
          Ok(Json.toJson(post))
    } getOrElse NotFound
   }
}
