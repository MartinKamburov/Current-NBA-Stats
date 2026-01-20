package com.nba_stats.backend.teams;


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


    // if I want to load data only once we use PostConstruct

    @GetMapping("/get_teams")
    public List<TeamModel> getTeams(){
        RestClient restClient = RestClient.builder()
                .baseUrl("https://v2.nba.api-sports.io/")
                .build();

        TeamModel allTeams =  restClient.get()
                .uri("/teams?")
                .header("x-apisports-key", NBA_API_KEY) // Note: This API uses custom headers, not Basic Auth
                .retrieve()
                .body(TeamModel.class);

        return allTeams;
    }

}
