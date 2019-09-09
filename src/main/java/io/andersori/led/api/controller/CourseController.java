package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.ICourseService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class CourseController {

    @Autowired
    @Qualifier("CourseService")
    private ICourseService courseService;

    public CourseController() {

        Spark.get("/courses", (req, res) -> {
            return courseService.getCouses();
        }, new JsonTransformer());
        
    }
}