package io.andersori.led.api.repository;

import io.andersori.led.api.entity.SchoolClass;

public class SchoolClassRepositoryIm extends DAOHibernate<SchoolClass> implements SchoolClassRepositoryIn {

    protected SchoolClassRepositoryIm(Class<SchoolClass> type) {
        super(type);
    }

    public SchoolClassRepositoryIm() {
        this(SchoolClass.class);
    }
}