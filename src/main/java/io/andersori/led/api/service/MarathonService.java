package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.MarathonDto;
import io.andersori.led.api.entity.Marathon;
import io.andersori.led.api.repository.MarathonRepositoryIn;

@Service("MarathonService")
public class MarathonService implements IMarathonService {

    @Autowired
    @Qualifier("MarathonRepositoryIm")
    private MarathonRepositoryIn marathonRepository;

    @Override
    public void register(MarathonDto marathon) {
        marathonRepository.save(marathon.toEntity(marathon));
    }

	@Override
	public List<MarathonDto> getMarathons() {
        return marathonRepository.findAll()
        .stream()
        .map((Marathon m) -> {
            MarathonDto bean = new MarathonDto();
            return bean.toDto(m);
        })
        .collect(Collectors.toList());
	}

    @Override
    public Optional<MarathonDto> get(Long id) {
        Optional<Marathon> result = marathonRepository.get(id);

        if(result.isPresent()){
            MarathonDto bean = new MarathonDto();
            return Optional.of(bean.toDto(result.get()));
        }

        return Optional.empty();
    }
    
}