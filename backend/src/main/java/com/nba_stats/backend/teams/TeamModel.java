package com.nba_stats.backend.teams;


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
    private int id;
    private String name;
    private String code;
    private String league;
    private String conference;
    private String division;
    private String search;
}
