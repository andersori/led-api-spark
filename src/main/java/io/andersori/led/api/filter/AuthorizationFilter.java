package io.andersori.led.api.filter;

import spark.Spark;

public class AuthorizationFilter {

    public AuthorizationFilter() {

        Spark.before((req, res) -> {
            String header = req.headers("HEADER_STRING");

            if(header != null && header.startsWith("TOKEN_PREFIX")) {
                
            }
        });
    }

}