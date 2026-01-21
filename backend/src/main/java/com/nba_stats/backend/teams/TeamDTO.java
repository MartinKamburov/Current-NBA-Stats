package com.nba_stats.backend.teams;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDTO {
    private int id;

    private String name;

    private String code;

    private String city;

    private String logo;

    private Boolean allStar;

    private Boolean nbaFranchise;

    private LeaguesDTO leagues;

}