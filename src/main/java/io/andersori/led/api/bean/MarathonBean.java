package io.andersori.led.api.bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import io.andersori.led.api.entity.Semester;

public class MarathonBean implements BeanLed<MarathonBean> {

    private Long id;
    private Semester semester;
    private LocalDate date;
    private List<ParticipantTeamBean> participants;

    public MarathonBean() {
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ParticipantTeamBean> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantTeamBean> participants) {
        this.participants = participants;
    }


    @Override
    public void toBean(Optional<MarathonBean> entity) {

    }

    @Override
    public MarathonBean toEntity() {
		return null;
	}

    
}