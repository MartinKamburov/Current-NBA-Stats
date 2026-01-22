package com.nba_stats.backend.player;

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
    @Column (name="id")
    private int id;

    @Column (name="name")
    private String name;





}
