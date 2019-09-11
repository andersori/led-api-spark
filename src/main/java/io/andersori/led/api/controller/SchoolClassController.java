package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.ISchoolClassService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class SchoolClassController extends PrivatePath {

    @Autowired
    @Qualifier("SchoolClassService")
    private ISchoolClassService schoolClassService;

    public SchoolClassController() {
    	super("/schoolclasses");
    	
        Spark.get(getPath(), (req, res) -> {
            return schoolClassService.getSchoolClasses();
        }, new JsonTransformer());
        
    }
}