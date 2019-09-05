package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.MarathonBean;

public interface MarathonServiceIn extends Service<MarathonBean> {

    public void register(MarathonBean marathon);

    public List<MarathonBean> getMarathons();

}