package com.nba_stats.backend.player;

import com.nba_stats.backend.teams.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<TeamModel, Integer> {

}
