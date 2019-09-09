package io.andersori.led.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Marathon;

@JsonIgnoreProperties({})
public class MarathonDto extends Dto<Marathon, MarathonDto> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("semester")
    private SemesterDto semester;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("participants")
    private List<ParticipantTeamDto> participants = new ArrayList<>();

    public MarathonDto(Class<Marathon> sourceType, Class<MarathonDto> destinationType) {
        super(sourceType, destinationType);
    }

    public MarathonDto() {
        this(Marathon.class, MarathonDto.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SemesterDto getSemester() {
        return this.semester;
    }

    public void setSemester(SemesterDto semester) {
        this.semester = semester;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ParticipantTeamDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantTeamDto> participants) {
        this.participants = participants;
    }

}