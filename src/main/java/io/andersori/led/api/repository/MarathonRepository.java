package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Marathon;

@Repository("MarathonRepository")
public class MarathonRepository extends DAOHibernate<Marathon> implements IMarathonRepository {

    protected MarathonRepository(Class<Marathon> type) {
        super(type);
    }
    
    public MarathonRepository() {
        this(Marathon.class);
    }
    
}