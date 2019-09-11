package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.dto.MarathonDTO;

public interface IMarathonService extends Service<MarathonDTO> {

    public void register(MarathonDTO marathon);

    public List<MarathonDTO> getMarathons();

}