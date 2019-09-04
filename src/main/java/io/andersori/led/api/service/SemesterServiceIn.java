package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.SemesterBean;

public interface SemesterServiceIn {

    public void register(SemesterBean semester);

    public List<SemesterBean> getSemesters();

}