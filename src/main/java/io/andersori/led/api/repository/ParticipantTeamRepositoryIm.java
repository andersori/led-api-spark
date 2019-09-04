package io.andersori.led.api.repository;

import io.andersori.led.api.entity.ParticipantTeam;

public class ParticipantTeamRepositoryIm extends DAOHibernate<ParticipantTeam> implements ParticipantTeamRepositoryIn {

    protected ParticipantTeamRepositoryIm(Class<ParticipantTeam> type) {
        super(type);
    }

    public ParticipantTeamRepositoryIm() {
        this(ParticipantTeam.class);
    }
    
}