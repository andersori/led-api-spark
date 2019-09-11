package io.andersori.led.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Team;

@JsonIgnoreProperties({})
public class TeamDTO extends DTO<Team, TeamDTO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private UserLedDTO user;

    @JsonProperty("students")
    private List<StudentDTO> students = new ArrayList<>();

    @JsonProperty("participations")
    private List<ParticipantTeamDTO> participations = new ArrayList<>();

    public TeamDTO(Class<Team> sourceType, Class<TeamDTO> destinationType) {
        super(sourceType, destinationType);
    }
    public TeamDTO() {
        this(Team.class, TeamDTO.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLedDTO getUser() {
        return this.user;
    }

    public void setUser(UserLedDTO user) {
        this.user = user;
    }

    public List<StudentDTO> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public List<ParticipantTeamDTO> getParticipations() {
        return this.participations;
    }

    public void setParticipations(List<ParticipantTeamDTO> participations) {
        this.participations = participations;
    }
    
}