package com.nba_stats.backend.player;

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

    @Id //This annotation is what tells spring that it's the primary key
    @Column (name="id")
    private int id;

    @Column (name="name")
    private String name;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private PlayerStatsModel stats;

    @ManyToOne
    @JoinColumn(name = "team")
    private TeamModel team;

    @Column (name = "season")
    private int season;

    @Column (name = "country")
    private String country;

    @Column (name = "search")
    private String search;


}
