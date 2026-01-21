package com.nba_stats.backend.teams;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Value("${nba_stats_api_key}")
    private String NBA_API_KEY;

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }


    // If I want to load data only once we use PostConstruct

    @GetMapping("/get_teams")
    public List<TeamModel> getTeams(){
        return teamRepository.findAll();
    }





}
