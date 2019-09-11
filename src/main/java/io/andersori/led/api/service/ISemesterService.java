package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.SemesterDTO;

public interface ISemesterService {

    public void register(SemesterDTO semester);

    public List<SemesterDTO> getSemesters();

}