package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.ISemesterService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class SemesterController extends PrivatePath {

    @Autowired
    @Qualifier("SemesterService")
    private ISemesterService semesterService;

    public SemesterController() {
    	super("/semesters");
    	
        Spark.get(getPath(), (req, res) -> {
            return semesterService.getSemesters();
        }, new JsonTransformer());
        
    }
}