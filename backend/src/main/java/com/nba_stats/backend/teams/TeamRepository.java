package com.nba_stats.backend.teams;

import org.springframework.data.jpa.repository.JpaRepository;

//Acts as a middleman to communicate with my database without having to write any actual code.

public interface TeamRepository extends JpaRepository<TeamModel, Integer> {
}
