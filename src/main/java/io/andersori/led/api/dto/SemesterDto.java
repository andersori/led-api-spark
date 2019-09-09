package io.andersori.led.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Semester;

@JsonIgnoreProperties({})
public class SemesterDto extends Dto<Semester, SemesterDto> {

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("numberSemester")
    private Integer numberSemester;

    public SemesterDto(Class<Semester> sourceType, Class<SemesterDto> destinationType) {
        super(sourceType, destinationType);
    }

    public SemesterDto() {
        this(Semester.class, SemesterDto.class);
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

}