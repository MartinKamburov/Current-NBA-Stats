package com.nba_stats.backend.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

// This wrapper class is used as a bridge between the raw JSON data from the API and my Java objects
// Without this wrapper, Jackson wouldn't know which part of the big object should be mapped to the TeamModel list.
// Jackson automatically maps the data from the response to
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // This is used to grab only the data inside the response, basically ignoring any other parameters
public class TeamResponseWrapper {
    private List<TeamDTO> response;
}
