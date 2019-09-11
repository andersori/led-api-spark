package io.andersori.led.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Marathon;

@JsonIgnoreProperties({})
public class MarathonDTO extends DTO<Marathon, MarathonDTO> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("semester")
    private SemesterDTO semester;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("participants")
    private List<ParticipantTeamDTO> participants = new ArrayList<>();

    public MarathonDTO(Class<Marathon> sourceType, Class<MarathonDTO> destinationType) {
        super(sourceType, destinationType);
    }

    public MarathonDTO() {
        this(Marathon.class, MarathonDTO.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SemesterDTO getSemester() {
        return this.semester;
    }

    public void setSemester(SemesterDTO semester) {
        this.semester = semester;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ParticipantTeamDTO> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantTeamDTO> participants) {
        this.participants = participants;
    }

}