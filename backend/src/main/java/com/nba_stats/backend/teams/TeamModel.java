package com.nba_stats.backend.teams;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This is the entity for the information we input into the database

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

    @Column(name = "city")
    private String city;

    @Column(name = "logo")
    private String logo;

    @Column(name = "allstar")
    private Boolean allStar;

    @Column(name = "nbafranchise")
    private Boolean nbaFranchise;
}
