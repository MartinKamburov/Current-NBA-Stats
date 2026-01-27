package com.nba_stats.backend.player.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
public class StandardDTO {
    private int jersey;
    private boolean active;
    private String pos;
}
