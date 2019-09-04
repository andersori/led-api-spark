package io.andersori.led.api.bean;

import java.util.Optional;

import io.andersori.led.api.entity.Semester;

public class SemesterBean implements BeanLed<Semester> {

    private Integer year;
    private Integer numberSemester;

    public SemesterBean() {

    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberSemester() {
        return this.numberSemester;
    }

    public void setNumberSemester(Integer numberSemester) {
        this.numberSemester = numberSemester;
    }

    @Override
    public void toBean(Optional<Semester> entity) {
        if(entity.isPresent()){
            Semester e = entity.get();
            this.setNumberSemester(e.getNumberSemester());
            this.setYear(e.getYear());
        }
    }

    @Override
    public Semester toEntity() {
        Semester entity = new Semester();
        entity.setNumberSemester(this.getNumberSemester());
        entity.setYear(this.getYear());
        return entity;
	}

}