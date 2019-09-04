package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.StudentBean;

public interface StudentServiceIn {

    public void register(StudentBean student);

    public List<StudentBean> getStudents();

}