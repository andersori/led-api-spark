package io.andersori.led.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.House;
import io.andersori.led.api.entity.ParticipantTeam;

@JsonIgnoreProperties({})
public class ParticipantTeamDto extends Dto<ParticipantTeam, ParticipantTeamDto> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("team")
    private TeamDto team;

    @JsonProperty("score")
    private Integer score = 0;

    @JsonProperty("entryDate")
    private LocalDateTime entryDate = LocalDateTime.now();

    @JsonProperty("house")
    private House house = House.UNDEFINED;

    @JsonProperty("marathon")
    private MarathonDto marathon;

    public ParticipantTeamDto(Class<ParticipantTeam> sourceType, Class<ParticipantTeamDto> destinationType) {
        super(sourceType, destinationType);
    }

    public ParticipantTeamDto() {
        this(ParticipantTeam.class, ParticipantTeamDto.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamDto getTeam() {
        return this.team;
    }

    public void setTeam(TeamDto team) {
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

    public MarathonDto getMarathon() {
        return this.marathon;
    }

    public void setMarathon(MarathonDto marathon) {
        this.marathon = marathon;
    }

}