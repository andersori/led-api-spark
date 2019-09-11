package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.Team;

@Repository("TeamRepository")
public class TeamRepository extends DAOHibernate<Team> implements ITeamRepository {

    protected TeamRepository(Class<Team> type) {
        super(type);
    }

    public TeamRepository() {
        this(Team.class);
    }
    
}