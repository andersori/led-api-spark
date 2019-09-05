package io.andersori.led.api.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Course;
import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.entity.Student;

@JsonIgnoreProperties({})
public class CourseBean implements BeanLed<Course> {

    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("students")
    private List<StudentBean> students = new ArrayList<>();

    @JsonProperty("schoolClasses")
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
            this.setId(c.getId());
            this.setName(c.getName());

            this.setSchoolClasses(c.getSchoolClasses()
            .stream()
            .map((SchoolClass s) -> {
                SchoolClassBean bean = new SchoolClassBean();
                bean.toBean(Optional.of(s));
                return bean;
            })
            .collect(Collectors.toList()));

            this.setStudents(c.getStudents()
            .stream()
            .map((Student s) -> {
                StudentBean bean = new StudentBean();
                bean.toBean(Optional.of(s));
                return bean;
            })
            .collect(Collectors.toList()));
        }
    }

    @Override
    public Course toEntity() {
        Course entity = new Course();
        entity.setId(this.getId());
        entity.setName(this.getName());

        entity.setSchoolClasses(this.getSchoolClasses()
        .stream()
        .map((SchoolClassBean s) -> s.toEntity())
        .collect(Collectors.toList()));

        entity.setStudents(this.getStudents()
        .stream()
        .map((StudentBean s) -> s.toEntity())
        .collect(Collectors.toList()));

        return entity;
	} 
    
}