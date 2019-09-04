package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.CourseBean;

public interface CourseServiceIn {

    public void register(CourseBean course);

    public List<CourseBean> getCouses();

}