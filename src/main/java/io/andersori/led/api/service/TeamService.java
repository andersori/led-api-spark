package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.TeamDTO;
import io.andersori.led.api.entity.Team;
import io.andersori.led.api.repository.ITeamRepository;

@Service("TeamService")
public class TeamService implements ITeamService {
    
    @Autowired
    @Qualifier("TeamRepository")
    private ITeamRepository teamRepository;

    @Override
    public void register(TeamDTO team) {
        teamRepository.save(team.toEntity(team));
    }

	@Override
	public List<TeamDTO> getTeams() {
        return teamRepository.findAll()
        .stream()
        .map((Team e) -> {
            TeamDTO dto = new TeamDTO();
            return dto.toDto(e);
        })
        .collect(Collectors.toList());
	}

    @Override
    public Optional<TeamDTO> get(Long id) {
        Optional<Team> result = teamRepository.get(id);
        if(result.isPresent()){
            TeamDTO dto = new TeamDTO();
            return Optional.of(dto.toDto(result.get()));
        }
        return Optional.empty();
    }

}