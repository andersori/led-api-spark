package io.andersori.led.api.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.entity.Student;

public class SchoolClassBean implements BeanLed<SchoolClass> {

    private Long id;
    private String name;
    private String codClass;
    private SemesterBean semester;
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

    public SemesterBean getSemester() {
        return this.semester;
    }

    public void setSemester(SemesterBean semester) {
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
    public void toBean(Optional<SchoolClass> entity) {
        if(entity.isEmpty()){
            SchoolClass e = entity.get();
            this.setId(e.getId());
            this.setName(e.getName());
            this.setCodClass(e.getCodClass());
            
            SemesterBean semester = new SemesterBean();
            semester.toBean(Optional.of(e.getSemester()));
            this.setSemester(semester);

            CourseBean couse = new CourseBean();
            couse.toBean(Optional.of(e.getCourse()));
            this.setCourse(course);;

            this.setStudents(e.getStudents()
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
    public SchoolClass toEntity() {
        SchoolClass entity = new SchoolClass();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCodClass(this.getCodClass());
        entity.setSemester(this.getSemester().toEntity());
        entity.setCourse(this.getCourse().toEntity());

        entity.setStudents(this.getStudents()
        .stream()
        .map((StudentBean s) -> s.toEntity())
        .collect(Collectors.toList()));

        return entity;
	}

}