package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Team;

@Repository("TeamRepositoryIm")
public class TeamRepositoryIm extends DAOHibernate<Team> implements TeamRepositoryIn {

    protected TeamRepositoryIm(Class<Team> type) {
        super(type);
    }

    public TeamRepositoryIm() {
        this(Team.class);
    }
    
}