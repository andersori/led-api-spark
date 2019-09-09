package io.andersori.led.api.filter;

import java.util.Date;
import java.util.Optional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.andersori.led.api.config.Auditor;
import io.andersori.led.api.security.SecurityConstants;
import io.andersori.led.api.security.User;
import io.andersori.led.api.security.UserDetails;
import spark.Spark;

@Component
public class AuthenticationFilter {

    @Autowired
    private UserDetails userDetails;

    public AuthenticationFilter() {
        Spark.before((req, res) -> {
            User credentials = new ObjectMapper().readValue(req.body(), User.class);

            if(credentials != null) {
                Optional<User> result = userDetails.loadUserByUsername(credentials.getUsername());
                
                if(result.isPresent()) {
                    if(BCrypt.checkpw(credentials.getPassword(), result.get().getPassword())) {
                        
                        Auditor.setUser(result.get().getUsername());
                        
                        String token = JWT.create().withSubject(result.get().getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)).sign(Algorithm.HMAC512((SecurityConstants.SECRET.getBytes())));;
                        res.header("HEADER_STRING", "TOKEN_PREFIX" + token);
                        System.out.println(token);
                    }
                }
            }
            
            Spark.halt(401,"Go Away!");
        });
    }

}