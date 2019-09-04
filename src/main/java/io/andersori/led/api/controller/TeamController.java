package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.TeamServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class TeamController {
	
	@Autowired
	@Qualifier("TeamServiceIm")
	private TeamServiceIn teamService;
	
	public TeamController() {
		
		Spark.get("/teams", (req, res) -> {
			return teamService.getTeams();
		}, new JsonTransformer());
		
	}
	
}
