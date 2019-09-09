package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.IStudentService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("StudentService")
    private IStudentService studentService;

    public StudentController(){

        Spark.get("/students", (req, res) -> {
            return studentService.getStudents();
        }, new JsonTransformer());
    }
}