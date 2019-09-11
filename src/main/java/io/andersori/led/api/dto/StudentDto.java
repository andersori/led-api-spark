package io.andersori.led.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Student;

@JsonIgnoreProperties({})
public class StudentDTO extends DTO<Student, StudentDTO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("registration")
    private Long registration;

    @JsonProperty("course")
    private CourseDTO course;

    @JsonProperty("schoolClass")
    private SchoolClassDTO schoolClass;

    public StudentDTO(Class<Student> sourceType, Class<StudentDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public StudentDTO() {
        this(Student.class, StudentDTO.class);
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

    public CourseDTO getCourse() {
        return this.course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public SchoolClassDTO getSchoolClass() {
        return this.schoolClass;
    }

    public void setSchoolClass(SchoolClassDTO schoolClass) {
        this.schoolClass = schoolClass;
    }
    
}