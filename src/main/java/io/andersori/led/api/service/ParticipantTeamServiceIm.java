package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.ParticipantTeamBean;
import io.andersori.led.api.entity.ParticipantTeam;
import io.andersori.led.api.repository.ParticipantTeamRepositoryIn;

@Service("ParticipantTeamServiceIm")
public class ParticipantTeamServiceIm implements ParticipantTeamServiceIn {

    @Autowired
    @Qualifier("ParticipantTeamRepositoryIm")
    private ParticipantTeamRepositoryIn participantTeamRepository;

    @Override
    public void register(ParticipantTeamBean participant) {
        participantTeamRepository.save(participant.toEntity());
    }

	@Override
	public List<ParticipantTeamBean> getParticipants() {
        return participantTeamRepository.findAll()
        .stream()
        .map((ParticipantTeam p) -> {
            ParticipantTeamBean bean = new ParticipantTeamBean();
            bean.toBean(Optional.of(p));
            return bean;
        })
        .collect(Collectors.toList());
	}
    
}