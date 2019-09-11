package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.IMarathonService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class MarathonController extends PrivatePath {

    @Autowired
    @Qualifier("MarathonService")
    private IMarathonService marathonService;

    public MarathonController() {
    	super("/marathons");
    	
        Spark.get(getPath(), (req, res) -> {
            return marathonService.getMarathons();
        }, new JsonTransformer());
        
    }
}