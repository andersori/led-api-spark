package io.andersori.led.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Semester;

@JsonIgnoreProperties({})
public class SemesterDTO extends DTO<Semester, SemesterDTO> {

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("numberSemester")
    private Integer numberSemester;

    public SemesterDTO(Class<Semester> sourceType, Class<SemesterDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public SemesterDTO() {
        this(Semester.class, SemesterDTO.class);
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