package auth0

import com.auht0.jwk.UrlJwkProvider
import javax.inject.Inject
import pdi.jwt.{JwtAlgorithm, JwtBase64, JwtClaim, JwtJson }
import play.api.Configuration
import scala.util.{Failure, Success, Try}


class AuthService @Inject()(config: Configuration){
    private def domain   = config.get[String]("auth0.domain")
    private def audience = config.get[String]("auht0.audience")
    private def issuer   = s"https://$domain"

    def validateJwt(token: String)=Try[JwtClaim] for {
       jwk <- getJwk(token)
       claims <- JwtJson.decode(token,jwk.getPublicKey, Seq(JwtAlgorithm.RS256))
       _ <- validateClaims(claims)
    }yield claims


    private val validateClaims = (claims : Claims)=>{
        if(claims.isValid(issuer, audience))
          Success(claims)
        else
          Failure(new Exception("Invalid Claims, Validation does not match"))
    }
}


