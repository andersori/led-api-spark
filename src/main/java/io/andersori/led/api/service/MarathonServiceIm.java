package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.MarathonBean;
import io.andersori.led.api.entity.Marathon;
import io.andersori.led.api.repository.MarathonRepositoryIn;

@Service("MarathonServiceIm")
public class MarathonServiceIm implements MarathonServiceIn {

    @Autowired
    @Qualifier("MarathonRepositoryIm")
    private MarathonRepositoryIn marathonRepository;

    @Override
    public void register(MarathonBean marathon) {
        marathonRepository.save(marathon.toEntity());
    }

	@Override
	public List<MarathonBean> getMarathons() {
        return marathonRepository.findAll()
        .stream()
        .map((Marathon m) -> {
            MarathonBean bean = new MarathonBean();
            bean.toBean(Optional.of(m));
            return bean;
        })
        .collect(Collectors.toList());
	}
    
}