package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.TeamBean;

public interface TeamServiceIn extends Service<TeamBean> {

    public void register(TeamBean team);

    public List<TeamBean> getTeams();

}