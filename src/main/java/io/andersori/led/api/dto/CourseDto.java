package io.andersori.led.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Course;

@JsonIgnoreProperties({})
public class CourseDto extends Dto<Course, CourseDto> {

    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("students")
    private List<StudentDto> students = new ArrayList<>();

    @JsonProperty("schoolClasses")
    private List<SchoolClassDto> schoolClasses = new ArrayList<>();

    public CourseDto(Class<Course> sourceType, Class<CourseDto> destinationType) {
        super(sourceType, destinationType);
    }

    public CourseDto() {
        this(Course.class, CourseDto.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<SchoolClassDto> getSchoolClasses() {
        return this.schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDto> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
    
}