package io.andersori.led.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.House;
import io.andersori.led.api.entity.ParticipantTeam;

@JsonIgnoreProperties({})
public class ParticipantTeamDTO extends DTO<ParticipantTeam, ParticipantTeamDTO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("team")
    private TeamDTO team;

    @JsonProperty("score")
    private Integer score = 0;

    @JsonProperty("entryDate")
    private LocalDateTime entryDate = LocalDateTime.now();

    @JsonProperty("house")
    private House house = House.UNDEFINED;

    @JsonProperty("marathon")
    private MarathonDTO marathon;

    public ParticipantTeamDTO(Class<ParticipantTeam> sourceType, Class<ParticipantTeamDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public ParticipantTeamDTO() {
        this(ParticipantTeam.class, ParticipantTeamDTO.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamDTO getTeam() {
        return this.team;
    }

    public void setTeam(TeamDTO team) {
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

    public MarathonDTO getMarathon() {
        return this.marathon;
    }

    public void setMarathon(MarathonDTO marathon) {
        this.marathon = marathon;
    }

}