package io.andersori.led.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participant_teams")
public class ParticipantTeam extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer score = 0;

    @Column(name = "entry_date")
    private LocalDateTime entryDate = LocalDateTime.now();

    @Column(nullable = false)
    private House house = House.UNDEFINED;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marathon_id", nullable = false)
    private Marathon marathon;

    public ParticipantTeam() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public House getHouse() {
        return this.house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Marathon getMarathon() {
        return this.marathon;
    }

    public void setMarathon(Marathon marathon) {
        this.marathon = marathon;
    }

}