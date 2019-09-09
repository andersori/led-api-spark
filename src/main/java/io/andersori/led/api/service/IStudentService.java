package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.StudentDto;

public interface IStudentService {

    public void register(StudentDto student);

    public List<StudentDto> getStudents();

}