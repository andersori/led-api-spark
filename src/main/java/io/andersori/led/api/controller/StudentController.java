package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.StudentServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("StudentServiceIm")
    private StudentServiceIn studentService;

    public StudentController(){

        Spark.get("/students", (req, res) -> {
            return studentService.getStudents();
        }, new JsonTransformer());
    }
}