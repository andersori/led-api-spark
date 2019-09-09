package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.ParticipantTeamDto;

public interface IParticipantTeamService {

    public void register(ParticipantTeamDto participant);

    public List<ParticipantTeamDto> getParticipants();

}