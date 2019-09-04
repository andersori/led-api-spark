package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Semester;

@Repository("SemesterRepositoryIm")
public class SemesterRepositoryIm extends DAOHibernate<Semester> implements SemesterRepositoryIn {

    protected SemesterRepositoryIm(Class<Semester> type) {
        super(type);
    }

    public SemesterRepositoryIm() {
        this(Semester.class);
    }
    
}