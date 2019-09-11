package io.andersori.led.api.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;

import org.springframework.stereotype.Component;

import io.andersori.led.api.config.Auditor;
import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.security.SecurityConstants;
import spark.Spark;

@Component
public class AuthorizationFilter extends PrivatePath {

    public AuthorizationFilter() {
    	super("/*");
    	
        Spark.before(getPath(), (req, res) -> {
            boolean authorized = false;
            String msg = "Get away!";

            String token = req.headers(SecurityConstants.HEADER_STRING);

            if(token != null && token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
                try {
                    String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

                    if(user != null){
                        Auditor.setUser(user);
                        authorized = true;
                    }

                } catch(SignatureVerificationException e) {
                    msg = "Invalid Token";
                } catch(JWTDecodeException e) {
                    msg = "Invalid JSON";
                }
                
            }

            if(!authorized) {
                Spark.halt(401, msg);
            }

        });
    }

}