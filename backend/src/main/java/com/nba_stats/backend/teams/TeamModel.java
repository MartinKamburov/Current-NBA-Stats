package com.nba_stats.backend.teams;


import com.nba_stats.backend.player.PlayerModel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy="team")
    private List<PlayerModel> players;

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
