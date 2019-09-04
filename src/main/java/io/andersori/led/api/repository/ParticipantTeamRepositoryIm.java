package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.ParticipantTeam;

@Repository("ParticipantTeamRepositoryIm")
public class ParticipantTeamRepositoryIm extends DAOHibernate<ParticipantTeam> implements ParticipantTeamRepositoryIn {

    protected ParticipantTeamRepositoryIm(Class<ParticipantTeam> type) {
        super(type);
    }

    public ParticipantTeamRepositoryIm() {
        this(ParticipantTeam.class);
    }
    
}