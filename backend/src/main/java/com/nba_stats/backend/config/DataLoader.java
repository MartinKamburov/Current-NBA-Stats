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




        //I need to grab all the nba teams and in the players get request, so I would swap out the team id for each team, and only include ones that are in the nba.
        //I would then map all the players information into the players table. Finally, after that I can grab each player's statistics and input them into the database. *Remember I can only take 100 queries per day*

        //Instead of loading every players statistics right away. In the frontend when you select a player that's when it makes an API call to the NBA API and if it's not in my Database we take the players statistics and put them in the database.
        //If the player is in the immediate database then just show his information and don't make the NBA API call. This way we won't run into the problem of querying too much since there is a limit.

    }
}
