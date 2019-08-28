package io.andersori.led.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(nullable = false, length = 200)
    @Size(min = 2, max = 200)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<SchoolClass> schoolClasses = new ArrayList<>();

    public Course() {

    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
     
}