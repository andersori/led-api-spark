package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Course;

@Repository("CourseRepositoryIm")
public class CourseRepositoryIm extends DAOHibernate<Course> implements CourseRepositoryIn {

    protected CourseRepositoryIm(Class<Course> type) {
        super(type);
    }

    public CourseRepositoryIm() {
        this(Course.class);
    }

}