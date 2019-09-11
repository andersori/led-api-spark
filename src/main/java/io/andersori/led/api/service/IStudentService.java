package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.StudentDTO;

public interface IStudentService {

    public void register(StudentDTO student);

    public List<StudentDTO> getStudents();

}