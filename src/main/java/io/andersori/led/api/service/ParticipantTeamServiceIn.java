package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.ParticipantTeamBean;

public interface ParticipantTeamServiceIn {

    public void register(ParticipantTeamBean participant);

    public List<ParticipantTeamBean> getParticipants();

}