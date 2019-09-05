package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.TeamBean;
import io.andersori.led.api.entity.Team;
import io.andersori.led.api.repository.TeamRepositoryIn;

@Service("TeamServiceIm")
public class TeamServiceIm implements TeamServiceIn {
    
    @Autowired
    @Qualifier("TeamRepositoryIm")
    private TeamRepositoryIn teamRepository;

    @Override
    public void register(TeamBean team) {
        teamRepository.save(team.toEntity());
    }

	@Override
	public List<TeamBean> getTeams() {
        return teamRepository.findAll()
        .stream()
        .map((Team e) -> {
            TeamBean bean = new TeamBean();
            bean.toBean(Optional.of(e));
            return bean;
        })
        .collect(Collectors.toList());
	}

    @Override
    public Optional<TeamBean> get(Long id) {
        Optional<Team> result = teamRepository.get(id);
        
        if(result.isPresent()){
            TeamBean bean = new TeamBean();
            bean.toBean(result);
            return Optional.of(bean);
        }

        return Optional.empty();
    }

}