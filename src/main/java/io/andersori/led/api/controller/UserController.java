package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.UserServiceIn;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("UserServiceIm")
	private UserServiceIn userService;
	
	public UserController() {
		
		Spark.get("/users", (req, res) -> {
			res.type("application/json;charset=utf-8");
			return userService.getUsers();
		}, new JsonTransformer());
		
	}
	
}
