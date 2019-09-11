package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.TeamDTO;

public interface ITeamService extends Service<TeamDTO> {

    public void register(TeamDTO team);

    public List<TeamDTO> getTeams();

}