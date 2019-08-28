package io.andersori.led.api.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.andersori.led.api.entity.Course;

public class CourseBean implements BeanLed<Course> {

    private Long id;
    private String name;
    private List<StudentBean> students = new ArrayList<>();
    private List<SchoolClassBean> schoolClasses = new ArrayList<>();

    public CourseBean() {

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

    public List<StudentBean> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

    public List<SchoolClassBean> getSchoolClasses() {
        return this.schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassBean> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    @Override
    public void toBean(Optional<Course> entity) {
        if(entity.isPresent()){
            Course c = entity.get();
            c.setId(this.getId());
            c.setName(this.getName());
            c.setSchoolClasses(this.getSchoolClasses()
                                    .stream()
                                    .map(u -> u.toEntity()).collect(Collectors.toList()));

                                    c.setStudents(this.getStudents());

        }
    }

    @Override
    public Course toEntity() {
        return null;
	} 
    
}