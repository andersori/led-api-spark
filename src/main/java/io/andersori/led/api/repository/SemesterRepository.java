package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Semester;

@Repository("SemesterRepository")
public class SemesterRepository extends DAOHibernate<Semester> implements ISemesterRepository {

    protected SemesterRepository(Class<Semester> type) {
        super(type);
    }

    public SemesterRepository() {
        this(Semester.class);
    }
    
}