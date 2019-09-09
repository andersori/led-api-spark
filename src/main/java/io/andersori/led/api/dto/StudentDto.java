package io.andersori.led.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Student;

@JsonIgnoreProperties({})
public class StudentDto extends Dto<Student, StudentDto> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("registration")
    private Long registration;

    @JsonProperty("course")
    private CourseDto course;

    @JsonProperty("schoolClass")
    private SchoolClassDto schoolClass;

    public StudentDto(Class<Student> sourceType, Class<StudentDto> destinationType) {
        super(sourceType, destinationType);
    }

    public StudentDto() {
        this(Student.class, StudentDto.class);
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

    public Long getRegistration() {
        return this.registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public CourseDto getCourse() {
        return this.course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public SchoolClassDto getSchoolClass() {
        return this.schoolClass;
    }

    public void setSchoolClass(SchoolClassDto schoolClass) {
        this.schoolClass = schoolClass;
    }
    
}