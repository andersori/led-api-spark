package io.andersori.led.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Team;

@JsonIgnoreProperties({})
public class TeamDto extends Dto<Team, TeamDto> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private UserLedDto user;

    @JsonProperty("students")
    private List<StudentDto> students = new ArrayList<>();

    @JsonProperty("participations")
    private List<ParticipantTeamDto> participations = new ArrayList<>();

    public TeamDto(Class<Team> sourceType, Class<TeamDto> destinationType) {
        super(sourceType, destinationType);
    }
    public TeamDto() {
        this(Team.class, TeamDto.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLedDto getUser() {
        return this.user;
    }

    public void setUser(UserLedDto user) {
        this.user = user;
    }

    public List<StudentDto> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<ParticipantTeamDto> getParticipations() {
        return this.participations;
    }

    public void setParticipations(List<ParticipantTeamDto> participations) {
        this.participations = participations;
    }
    
}