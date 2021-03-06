package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.ParticipantTeamDTO;
import io.andersori.led.api.entity.ParticipantTeam;
import io.andersori.led.api.repository.IParticipantTeamRepository;

@Service("ParticipantTeamService")
public class ParticipantTeamService implements IParticipantTeamService {

    @Autowired
    @Qualifier("ParticipantTeamRepository")
    private IParticipantTeamRepository participantTeamRepository;

    @Override
    public void register(ParticipantTeamDTO participant) {
        participantTeamRepository.save(participant.toEntity(participant));
    }

	@Override
	public List<ParticipantTeamDTO> getParticipants() {
        return participantTeamRepository.findAll()
        .stream()
        .map((ParticipantTeam p) -> {
            ParticipantTeamDTO dto = new ParticipantTeamDTO();
            return dto.toDto(p);
        })
        .collect(Collectors.toList());
	}
    
}