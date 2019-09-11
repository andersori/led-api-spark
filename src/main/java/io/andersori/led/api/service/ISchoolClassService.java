package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.SchoolClassDTO;

public interface ISchoolClassService {

    public void register(SchoolClassDTO schoolClass);

    public List<SchoolClassDTO> getSchoolClasses();

}