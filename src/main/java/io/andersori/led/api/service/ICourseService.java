package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.CourseDto;

public interface ICourseService {

    public void register(CourseDto course);

    public List<CourseDto> getCouses();

}