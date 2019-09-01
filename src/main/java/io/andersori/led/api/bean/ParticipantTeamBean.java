package io.andersori.led.api.bean;

import java.time.LocalDateTime;
import java.util.Optional;

import io.andersori.led.api.entity.House;
import io.andersori.led.api.entity.ParticipantTeam;

public class ParticipantTeamBean implements BeanLed<ParticipantTeam> {

    private Long id;
    private TeamBean team;
    private Integer score = 0;
    private LocalDateTime entryDate = LocalDateTime.now();
    private House house = House.UNDEFINED;
    private MarathonBean marathon;

    public ParticipantTeamBean() {
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamBean getTeam() {
        return this.team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public House getHouse() {
        return this.house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public MarathonBean getMarathon() {
        return this.marathon;
    }

    public void setMarathon(MarathonBean marathon) {
        this.marathon = marathon;
    }

    @Override
    public void toBean(Optional<ParticipantTeam> entity) {
        if(entity.isPresent()){
            ParticipantTeam e = entity.get();
            this.setId(e.getId());
            this.setEntryDate(e.getEntryDate());
            this.setScore(e.getScore());
            this.setHouse(e.getHouse());

            TeamBean team = new TeamBean();
            team.toBean(Optional.of(e.getTeam()));
            this.setTeam(team);

            MarathonBean marathon = new MarathonBean();
            marathon.toBean(Optional.of(e.getMarathon()));
            this.setMarathon(marathon);
        }
    }

    @Override
    public ParticipantTeam toEntity() {
        ParticipantTeam entity = new ParticipantTeam();
        entity.setId(this.getId());
        entity.setEntryDate(this.getEntryDate());
        entity.setScore(this.getScore());
        entity.setHouse(this.getHouse());
        entity.setTeam(this.getTeam().toEntity());
        entity.setMarathon(this.getMarathon().toEntity());
        return entity;
	}

}