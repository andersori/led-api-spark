package io.andersori.led.api.repository;

import io.andersori.led.api.entity.Marathon;

public class MarathonRepositoryIm extends DAOHibernate<Marathon> implements MarathonRepositoryIn {

    protected MarathonRepositoryIm(Class<Marathon> type) {
        super(type);
    }
    
    public MarathonRepositoryIm() {
        this(Marathon.class);
    }
    
}