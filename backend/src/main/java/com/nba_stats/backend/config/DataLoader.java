package com.nba_stats.backend.config;

import com.nba_stats.backend.teams.TeamModel;
import com.nba_stats.backend.teams.TeamRepository;
import com.nba_stats.backend.teams.TeamResponseWrapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
//This Data Loader java class uses the CommandLineRunner to load the database before

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${nba_stats_api_key}")
    private String NBA_API_KEY;

    private final TeamRepository teamRepository;

    public DataLoader(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // I have to check if the data already exists to prevent duplicates! This is a crucial step when data seeding.
        if (teamRepository.count() > 0){
            System.out.println("The database has already been seeded. Skipping data load.");
            return;
        }

        // Perform the tasks to grab the data from the NBA API convert it to a DTO then convert the DTO to an entity and save it in the database
        RestClient restClient = RestClient.builder()
                .baseUrl("https://v2.nba.api-sports.io/")
                .build();

        TeamResponseWrapper allTeams =  restClient.get()
                .uri("/teams?league=standard")
                .header("x-apisports-key", NBA_API_KEY) // Note: This API uses custom headers, not Basic Auth
                .retrieve()
                .body(TeamResponseWrapper.class);

        ModelMapper modelMapper = new ModelMapper();

        if (allTeams != null && allTeams.getResponse() != null) {
            List<TeamModel> listOfTeams =  allTeams.getResponse().stream()
                    .map(dto -> modelMapper.map(dto, TeamModel.class))
                    .toList();

            teamRepository.saveAll(listOfTeams);
        }
    }
}
