package com.nba_stats.backend.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PlayerController {

    @GetMapping //This handles http get requests
    public void getPlayers(){

    }

}
