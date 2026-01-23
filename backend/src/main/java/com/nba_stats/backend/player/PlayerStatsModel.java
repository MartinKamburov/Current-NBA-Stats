package com.nba_stats.backend.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="players_stats")
public class PlayerStatsModel {

    @Id
    private int id; //This will hold the same value as player.id

    @OneToOne
    @MapsId //This is what links this ID to the player entity
    @JoinColumn(name="id")
    private PlayerModel player;

    @Column (name = "game")
    private int game;

    @Column (name = "team")
    private int team;

    @Column (name = "season")
    private int season;


}
