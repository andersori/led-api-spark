package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.MarathonDto;

public interface IMarathonService extends Service<MarathonDto> {

    public void register(MarathonDto marathon);

    public List<MarathonDto> getMarathons();

}