package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.CourseServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class CourseController {

    @Autowired
    @Qualifier("CourseServiceIn")
    private CourseServiceIn courseService;

    public CourseController() {

        Spark.get("/courses", (req, res) -> {
            return courseService.getCouses();
        }, new JsonTransformer());
        
    }
}