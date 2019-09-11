package io.andersori.led.api.repository;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.ParticipantTeam;

@Repository("ParticipantTeamRepository")
public class ParticipantTeamRepository extends DAOHibernate<ParticipantTeam> implements IParticipantTeamRepository {

    protected ParticipantTeamRepository(Class<ParticipantTeam> type) {
        super(type);
    }

    public ParticipantTeamRepository() {
        this(ParticipantTeam.class);
    }
    
}