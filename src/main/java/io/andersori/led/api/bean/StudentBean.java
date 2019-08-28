package io.andersori.led.api.bean;

import java.util.Optional;

public class StudentBean implements BeanLed<StudentBean> {

    private Long id;
    private String name;
    private Long registration;
    private CourseBean course;
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
    public void toBean(Optional<StudentBean> entity) {

    }

    @Override
    public StudentBean toEntity() {
      return null;
    }
    
}