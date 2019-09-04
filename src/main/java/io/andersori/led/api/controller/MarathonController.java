package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.MarathonServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class MarathonController {

    @Autowired
    @Qualifier("MarathonServiceIm")
    private MarathonServiceIn marathonService;

    public MarathonController() {

        Spark.get("/marathons", (req, res) -> {
            return marathonService.getMarathons();
        }, new JsonTransformer());
        
    }
}