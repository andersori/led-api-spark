package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.SchoolClassDto;

public interface ISchoolClassService {

    public void register(SchoolClassDto schoolClass);

    public List<SchoolClassDto> getSchoolClasses();

}