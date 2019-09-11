package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.CourseDTO;

public interface ICourseService {

    public void register(CourseDTO course);

    public List<CourseDTO> getCouses();

}