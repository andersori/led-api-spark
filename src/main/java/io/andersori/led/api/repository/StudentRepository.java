package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Student;

@Repository("StudentRepository")
public class StudentRepository extends DAOHibernate<Student> implements IStudentRepository {

    protected StudentRepository(Class<Student> type) {
        super(type);
    }

    public StudentRepository(){
        this(Student.class);
    }

}