package io.andersori.led.api.repository;

import io.andersori.led.api.entity.Student;

public class StudentRepositoryIm extends DAOHibernate<Student> implements StudentRepositoryIn {

    protected StudentRepositoryIm(Class<Student> type) {
        super(type);
    }

    public StudentRepositoryIm(){
        this(Student.class);
    }

}