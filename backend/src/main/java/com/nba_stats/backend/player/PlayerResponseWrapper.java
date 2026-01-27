package com.nba_stats.backend.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponseWrapper {
    private List<PlayerDTO> response;
}
