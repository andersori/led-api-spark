package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.SchoolClass;

@Repository("SchoolClassRepositoryIm")
public class SchoolClassRepositoryIm extends DAOHibernate<SchoolClass> implements SchoolClassRepositoryIn {

    protected SchoolClassRepositoryIm(Class<SchoolClass> type) {
        super(type);
    }

    public SchoolClassRepositoryIm() {
        this(SchoolClass.class);
    }
}