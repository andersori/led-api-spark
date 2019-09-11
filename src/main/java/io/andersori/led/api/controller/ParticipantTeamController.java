package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.security.PrivatePath;
import io.andersori.led.api.service.IParticipantTeamService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class ParticipantTeamController extends PrivatePath {

    @Autowired
    @Qualifier("ParticipantTeamService")
    private IParticipantTeamService participantTeamService;

    public ParticipantTeamController() {
    	super("/participants");
    	
        Spark.get(getPath(), (req, res) -> {
            return participantTeamService.getParticipants();
        }, new JsonTransformer());
        
    }
}