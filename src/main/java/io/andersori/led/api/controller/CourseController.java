package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.ICourseService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class CourseController extends PrivatePath {

	@Autowired
    @Qualifier("CourseService")
    private ICourseService courseService;

    public CourseController() {
    	super("/courses");
    	
        Spark.get(getPath(), (req, res) -> {
            return courseService.getCouses();
        }, new JsonTransformer());
        
    }
}