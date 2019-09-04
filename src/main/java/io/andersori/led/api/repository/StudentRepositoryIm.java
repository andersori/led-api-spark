package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Student;

@Repository("StudentRepositoryIm")
public class StudentRepositoryIm extends DAOHibernate<Student> implements StudentRepositoryIn {

    protected StudentRepositoryIm(Class<Student> type) {
        super(type);
    }

    public StudentRepositoryIm(){
        this(Student.class);
    }

}