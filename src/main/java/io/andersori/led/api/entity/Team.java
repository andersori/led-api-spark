package io.andersori.led.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_led_id")
    private UserLed user;

    @ManyToMany
    @JoinTable(
        name = "team_student",
        joinColumns = { @JoinColumn(name = "team_id") },
        inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private List<ParticipantTeam> participations;

    public Team() {
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLed getUser() {
        return this.user;
    }

    public void setUser(UserLed user) {
        this.user = user;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<ParticipantTeam> getParticipations() {
        return this.participations;
    }

    public void setParticipations(List<ParticipantTeam> participations) {
        this.participations = participations;
    }

}