package com.nba_stats.backend.teams;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="teams")
public class TeamModel {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "league")
    private String league;

    @Column(name = "conference")
    private String conference;

    @Column(name = "division")
    private String division;

    @Column(name = "search")
    private String search;
}
