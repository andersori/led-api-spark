package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.ParticipantTeamDto;
import io.andersori.led.api.entity.ParticipantTeam;
import io.andersori.led.api.repository.ParticipantTeamRepositoryIn;

@Service("ParticipantTeamService")
public class ParticipantTeamService implements IParticipantTeamService {

    @Autowired
    @Qualifier("ParticipantTeamRepositoryIm")
    private ParticipantTeamRepositoryIn participantTeamRepository;

    @Override
    public void register(ParticipantTeamDto participant) {
        participantTeamRepository.save(participant.toEntity(participant));
    }

	@Override
	public List<ParticipantTeamDto> getParticipants() {
        return participantTeamRepository.findAll()
        .stream()
        .map((ParticipantTeam p) -> {
            ParticipantTeamDto bean = new ParticipantTeamDto();
            return bean.toDto(p);
        })
        .collect(Collectors.toList());
	}
    
}