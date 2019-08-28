package io.andersori.led.api.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.andersori.led.api.entity.Semester;

public class SchoolClassBean implements BeanLed<SchoolClassBean> {

    private Long id;
    private String name;
    private String codClass;
    private Semester semester;
    private CourseBean course;
    private List<StudentBean> students = new ArrayList<>();

    public SchoolClassBean() {

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

    public String getCodClass() {
        return this.codClass;
    }

    public void setCodClass(String codClass) {
        this.codClass = codClass;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public CourseBean getCourse() {
        return this.course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public List<StudentBean> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

    @Override
    public void toBean(Optional<SchoolClassBean> entity) {

    }

    @Override
    public SchoolClassBean toEntity() {
		return null;
	}

}