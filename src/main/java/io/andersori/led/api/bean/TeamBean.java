package io.andersori.led.api.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.ParticipantTeam;
import io.andersori.led.api.entity.Student;
import io.andersori.led.api.entity.Team;

@JsonIgnoreProperties({})
public class TeamBean implements BeanLed<Team> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private UserLedBean user;

    @JsonProperty("students")
    private List<StudentBean> students = new ArrayList<>();

    @JsonProperty("participations")
    private List<ParticipantTeamBean> participations = new ArrayList<>();

    public TeamBean() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLedBean getUser() {
        return this.user;
    }

    public void setUser(UserLedBean user) {
        this.user = user;
    }

    public List<StudentBean> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

    public List<ParticipantTeamBean> getParticipations() {
        return this.participations;
    }

    public void setParticipations(List<ParticipantTeamBean> participations) {
        this.participations = participations;
    }

    @Override
    public void toBean(Optional<Team> entity) {
        if(entity.isPresent()){
            Team e = entity.get();
            this.setId(e.getId());

            UserLedBean user = new UserLedBean();
            user.toBean(Optional.of(e.getUser()));
            this.setUser(user);

            this.setStudents(e.getStudents()
            .stream()
            .map((Student s) -> {
                StudentBean bean = new StudentBean();
                bean.toBean(Optional.of(s));
                return bean;
            })
            .collect(Collectors.toList()));

            this.setParticipations(e.getParticipations()
            .stream()
            .map((ParticipantTeam s) -> {
                ParticipantTeamBean bean = new ParticipantTeamBean();
                bean.toBean(Optional.of(s));
                return bean;
            })
            .collect(Collectors.toList()));
        }
    }

    @Override
    public Team toEntity() {
        Team entity = new Team();
        entity.setId(this.getId());
        entity.setUser(this.getUser().toEntity());

        entity.setStudents(this.getStudents()
        .stream()
        .map((StudentBean s) -> s.toEntity())
        .collect(Collectors.toList()));

        entity.setParticipations(this.getParticipations()
        .stream()
        .map((ParticipantTeamBean p) -> p.toEntity())
        .collect(Collectors.toList()));

        return entity;
	}
    
}