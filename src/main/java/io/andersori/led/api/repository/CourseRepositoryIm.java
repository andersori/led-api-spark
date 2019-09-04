package io.andersori.led.api.repository;

import io.andersori.led.api.entity.Course;

public class CourseRepositoryIm extends DAOHibernate<Course> implements CourseRepositoryIn {

    protected CourseRepositoryIm(Class<Course> type) {
        super(type);
    }

    public CourseRepositoryIm() {
        this(Course.class);
    }
    
}