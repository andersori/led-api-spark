package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.SchoolClassBean;

public interface SchoolClassServiceIn {

    public void register(SchoolClassBean schoolClass);

    public List<SchoolClassBean> getSchoolClasses();

}