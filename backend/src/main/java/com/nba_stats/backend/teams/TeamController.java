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


    // If I want to load data only once we use PostConstruct

    @GetMapping("/get_teams")
    public List<TeamModel> getTeams(){
        RestClient restClient = RestClient.builder()
                .baseUrl("https://v2.nba.api-sports.io/")
                .build();

        TeamResponseWrapper allTeams =  restClient.get()
                .uri("/teams?league=standard")
                .header("x-apisports-key", NBA_API_KEY) // Note: This API uses custom headers, not Basic Auth
                .retrieve()
                .body(TeamResponseWrapper.class);

        ModelMapper modelMapper = new ModelMapper();

        return allTeams.getResponse().stream()
                .map(dto -> modelMapper.map(dto, TeamModel.class))
                .toList();
    }

}
