package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.SchoolClass;

@Repository("SchoolClassRepository")
public class SchoolClassRepository extends DAOHibernate<SchoolClass> implements ISchoolClassRepository {

    protected SchoolClassRepository(Class<SchoolClass> type) {
        super(type);
    }

    public SchoolClassRepository() {
        this(SchoolClass.class);
    }
    
}