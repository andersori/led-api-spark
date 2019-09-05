package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.SchoolClassServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class SchoolClassController {

    @Autowired
    @Qualifier("SchoolClassServiceIm")
    private SchoolClassServiceIn schoolClassService;

    public SchoolClassController() {

        Spark.get("/schoolclasses", (req, res) -> {
            return schoolClassService.getSchoolClasses();
        }, new JsonTransformer());
        
    }
}