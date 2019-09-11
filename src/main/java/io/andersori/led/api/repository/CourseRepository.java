package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Course;

@Repository("CourseRepository")
public class CourseRepository extends DAOHibernate<Course> implements ICourseRepository {

    protected CourseRepository(Class<Course> type) {
        super(type);
    }

    public CourseRepository() {
        this(Course.class);
    }

}