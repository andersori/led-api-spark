package io.andersori.led.api.bean;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Student;

@JsonIgnoreProperties({})
public class StudentBean implements BeanLed<Student> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("registration")
    private Long registration;

    @JsonProperty("course")
    private CourseBean course;

    @JsonProperty("schoolClass")
    private SchoolClassBean schoolClass;

    public StudentBean() {

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

    public CourseBean getCourse() {
        return this.course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public SchoolClassBean getSchoolClass() {
        return this.schoolClass;
    }

    public void setSchoolClass(SchoolClassBean schoolClass) {
        this.schoolClass = schoolClass;
    }
    
    @Override
    public void toBean(Optional<Student> entity) {
        if(entity.isPresent()){
            Student e = entity.get();
            this.setId(e.getId());
            this.setName(e.getName());
            this.setRegistration(e.getRegistration());

            CourseBean couse = new CourseBean();
            couse.toBean(Optional.of(e.getCourse()));
            this.setCourse(course);

            SchoolClassBean schoolClass = new SchoolClassBean();
            schoolClass.toBean(Optional.of(e.getSchoolClass()));
            this.setSchoolClass(schoolClass);
        }
    }

    @Override
    public Student toEntity() {
        Student entity = new Student();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setRegistration(this.getRegistration());
        entity.setCourse(this.getCourse().toEntity());
        entity.setSchoolClass(this.getSchoolClass().toEntity());
        return entity;
    }
    
}