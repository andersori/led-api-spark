package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.SemesterServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class SemesterController {

    @Autowired
    @Qualifier("SemesterServiceIn")
    private SemesterServiceIn semesterService;

    public SemesterController() {

        Spark.get("/semesters", (req, res) -> {
            return semesterService.getSemesters();
        }, new JsonTransformer());
        
    }
}