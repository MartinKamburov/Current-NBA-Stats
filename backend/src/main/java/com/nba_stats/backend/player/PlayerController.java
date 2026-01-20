package com.nba_stats.backend.player;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.util.List;

@RestController
@RequestMapping(path = "/api/players")
public class PlayerController {

    // This is how to get the environment variable
    @Value("${nba_stats_api_key}")
    private String NBA_API_KEY;

//    @GetMapping("/get-teams") //This handles http get requests
//    public String getTeams(){
//        RestClient restClient = RestClient.builder()
//                .baseUrl("https://v2.nba.api-sports.io/")
//                .build();
//
//        return restClient.get()
//                .uri("/teams?")
//                .header("x-apisports-key", NBA_API_KEY) // Note: This API uses custom headers, not Basic Auth
//                .retrieve()
//                .body(String.class);
//    }

    @GetMapping("/")
    public String getTeamsStatistics(){
        return "";
    }





}
