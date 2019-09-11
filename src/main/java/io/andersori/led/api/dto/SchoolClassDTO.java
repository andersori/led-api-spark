package io.andersori.led.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.SchoolClass;

@JsonIgnoreProperties({})
public class SchoolClassDTO extends DTO<SchoolClass, SchoolClassDTO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("codClass")
    private String codClass;

    @JsonProperty("semester")
    private SemesterDTO semester;

    @JsonProperty("course")
    private CourseDTO course;

    @JsonProperty("students")
    private List<StudentDTO> students = new ArrayList<>();

    public SchoolClassDTO(Class<SchoolClass> sourceType, Class<SchoolClassDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public SchoolClassDTO(){
        this(SchoolClass.class, SchoolClassDTO.class);
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

    public SemesterDTO getSemester() {
        return this.semester;
    }

    public void setSemester(SemesterDTO semester) {
        this.semester = semester;
    }

    public CourseDTO getCourse() {
        return this.course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<StudentDTO> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

}