package com.nba_stats.backend.player;

import com.nba_stats.backend.player.dtos.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {

    private int id;

    private String firstname;

    private String lastname;

    // This is the nested json structure
    private BirthDTO birth;

    private NbaDTO nba;

    private HeightDTO height;

    private WeightDTO weight;

    private String college;

    private String affiliation;

    private LeaguesDTO leagues;

}
