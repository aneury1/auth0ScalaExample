package repo

import javax.inject.Singleton
import models.{Comment, Post}

///@Singleton
object DataRepository{

   
   private val posts = Seq(
       Post(1, "New Blog 1"),
       Post(2, "New Blog 2"),
       Post(3, "New Blog 4")
   )

   private val comments = Seq(
       Comment(1,1,"This new Blog that I like it", "JXF"),
       Comment(3,4,"This new Blog that I like it", "JXF"),
       Comment(2,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
       Comment(1,3,"This new Blog that I like it", "JXF"),
   )

  
   def getPosts(id : Int ): Option[Post]= posts.collectFirst{
       case p if p.id == id => p
   }

   def getComments(postId: Int): Seq[Comment] = comments.collect{
       case c if c.postId == postId => c
   }
}