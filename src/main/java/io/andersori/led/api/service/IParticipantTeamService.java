package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.ParticipantTeamDTO;

public interface IParticipantTeamService {

    public void register(ParticipantTeamDTO participant);

    public List<ParticipantTeamDTO> getParticipants();

}