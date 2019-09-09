package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.TeamDto;

public interface ITeamService extends Service<TeamDto> {

    public void register(TeamDto team);

    public List<TeamDto> getTeams();

}