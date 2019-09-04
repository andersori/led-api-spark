package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.ParticipantTeamServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class ParticipantTeamController {

    @Autowired
    @Qualifier("ParticipantTeamServiceIm")
    private ParticipantTeamServiceIn participantTeamService;

    public ParticipantTeamController() {

        Spark.get("/participants", (req, res) -> {
            return participantTeamService.getParticipants();
        }, new JsonTransformer());
        
    }
}