package io.andersori.led.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Course;

@JsonIgnoreProperties({})
public class CourseDTO extends DTO<Course, CourseDTO> {

    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("students")
    private List<StudentDTO> students = new ArrayList<>();

    @JsonProperty("schoolClasses")
    private List<SchoolClassDTO> schoolClasses = new ArrayList<>();

    public CourseDTO(Class<Course> sourceType, Class<CourseDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public CourseDTO() {
        this(Course.class, CourseDTO.class);
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

    public List<StudentDTO> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public List<SchoolClassDTO> getSchoolClasses() {
        return this.schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDTO> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
    
}