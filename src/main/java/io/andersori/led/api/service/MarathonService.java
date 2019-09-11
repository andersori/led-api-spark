package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.MarathonDTO;
import io.andersori.led.api.entity.Marathon;
import io.andersori.led.api.repository.IMarathonRepository;

@Service("MarathonService")
public class MarathonService implements IMarathonService {

    @Autowired
    @Qualifier("MarathonRepository")
    private IMarathonRepository marathonRepository;

    @Override
    public void register(MarathonDTO marathon) {
        marathonRepository.save(marathon.toEntity(marathon));
    }

	@Override
	public List<MarathonDTO> getMarathons() {
        return marathonRepository.findAll()
        .stream()
        .map((Marathon m) -> {
            MarathonDTO bean = new MarathonDTO();
            return bean.toDto(m);
        })
        .collect(Collectors.toList());
	}

    @Override
    public Optional<MarathonDTO> get(Long id) {
        Optional<Marathon> result = marathonRepository.get(id);

        if(result.isPresent()){
            MarathonDTO bean = new MarathonDTO();
            return Optional.of(bean.toDto(result.get()));
        }

        return Optional.empty();
    }
    
}