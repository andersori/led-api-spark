package io.andersori.led.api.service;

import java.util.List;

import io.andersori.led.api.bean.MarathonBean;

public interface MarathonServiceIn {

    public void register(MarathonBean marathon);

    public List<MarathonBean> getMarathons();

}