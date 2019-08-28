package io.andersori.led.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marathons")
public class Marathon extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marathon_id")
    private Long id;

    @Embedded
    private Semester semester;

    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "marathon")
    private List<ParticipantTeam> participants;

    public Marathon() {
        
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

    public List<ParticipantTeam> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantTeam> participants) {
        this.participants = participants;
    }

}