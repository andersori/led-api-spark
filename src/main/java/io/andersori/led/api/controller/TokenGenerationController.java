package io.andersori.led.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.andersori.led.api.security.SecurityConstants;
import io.andersori.led.api.security.User;
import io.andersori.led.api.security.UserDetails;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Component
public class TokenGenerationController {

    @Autowired
    private UserDetails userDetails;
    
    public TokenGenerationController() {
        Spark.get("/token", (req, res) -> {
            User user = new ObjectMapper().readValue(req.body(), User.class);
            Optional<String> token = getToken(user);

            Map<String, String> response = new HashMap<>();

            if(token.isPresent()){
                response.put("token", token.get());
                return response;
            }

            response.put("token", "-");
            return response;
        }, new JsonTransformer());
    }

    private Optional<String> getToken(User user) {
        Optional<User> result = userDetails.loadUserByUsername(user.getUsername());
                
        if(result.isPresent()) {
            if(BCrypt.checkpw(user.getPassword(), result.get().getPassword())) {            
                return Optional.of(JWT.create().withSubject(result.get().getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)).sign(Algorithm.HMAC512((SecurityConstants.SECRET.getBytes()))));
            }
        }
        return Optional.empty();
    }

}