package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.SemesterDto;

public interface ISemesterService {

    public void register(SemesterDto semester);

    public List<SemesterDto> getSemesters();

}