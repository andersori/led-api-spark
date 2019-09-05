package io.andersori.led.api.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.Marathon;
import io.andersori.led.api.entity.ParticipantTeam;

@JsonIgnoreProperties({})
public class MarathonBean implements BeanLed<Marathon> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("semester")
    private SemesterBean semester;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("participants")
    private List<ParticipantTeamBean> participants = new ArrayList<>();

    public MarathonBean() {
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SemesterBean getSemester() {
        return this.semester;
    }

    public void setSemester(SemesterBean semester) {
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
    public void toBean(Optional<Marathon> entity) {
        if(entity.isPresent()){
            Marathon e = entity.get();
            this.setId(e.getId());
            this.setDate(e.getDate());

            SemesterBean sBean = new SemesterBean();
            sBean.toBean(Optional.of(e.getSemester()));
            this.setSemester(sBean);

            this.setParticipants(e.getParticipants()
            .stream()
            .map((ParticipantTeam p) -> {
                ParticipantTeamBean bean = new ParticipantTeamBean();
                bean.toBean(Optional.of(p));
                return bean;
            })
            .collect(Collectors.toList()));
        }
    }

    @Override
    public Marathon toEntity() {
        Marathon entity = new Marathon();
        entity.setId(this.getId());
        entity.setDate(this.getDate());
        entity.setSemester(this.getSemester().toEntity());

        entity.setParticipants(this.getParticipants()
        .stream()
        .map((ParticipantTeamBean p) -> p.toEntity())
        .collect(Collectors.toList()));
        
        return entity;
	}

}