package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.IStudentService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class StudentController extends PrivatePath {

    @Autowired
    @Qualifier("StudentService")
    private IStudentService studentService;

    public StudentController(){
    	super("/students");
    	
        Spark.get(getPath(), (req, res) -> {
            return studentService.getStudents();
        }, new JsonTransformer());
    }
}