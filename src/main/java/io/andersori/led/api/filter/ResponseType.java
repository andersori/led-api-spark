package io.andersori.led.api.filter;

import org.springframework.stereotype.Component;

import spark.Spark;

@Component
public class ResponseType {

    public ResponseType (){

        Spark.after((req, res) -> {
            res.type("application/json;charset=utf-8");
        });
    }
}