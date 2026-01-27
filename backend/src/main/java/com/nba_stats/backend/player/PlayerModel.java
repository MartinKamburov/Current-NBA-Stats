package com.nba_stats.backend.player;

import com.nba_stats.backend.player.dtos.*;
import com.nba_stats.backend.teams.TeamModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="players")
public class PlayerModel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    // This is the nested json structure
    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "nba")
    private String nbastart;

    private HeightDTO height;

    private WeightDTO weight;

    private String college;

    private String affiliation;

    private LeaguesDTO leagues;


}
