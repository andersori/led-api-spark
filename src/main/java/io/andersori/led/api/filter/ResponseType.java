package io.andersori.led.api.filter;

import spark.Spark;

public class ResponseType {

    public ResponseType (){

        Spark.after((req, res) -> {
            res.type("application/json;charset=utf-8");
        });
    }
}