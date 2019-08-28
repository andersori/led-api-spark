package io.andersori.led.api.bean;

import java.util.List;
import java.util.Optional;

public class TeamBean implements BeanLed<TeamBean> {

    private Long id;
    private UserLedBean user;
    private List<StudentBean> students;
    private List<ParticipantTeamBean> participations;

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
    public void toBean(Optional<TeamBean> entity) {

    }

    @Override
    public TeamBean toEntity() {
		return null;
	}
    
}