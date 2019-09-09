package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.IUserService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("UserService")
	private IUserService userService;
	
	public UserController() {
		
		Spark.get("/users", (req, res) -> {
			return userService.getUsers();
		}, new JsonTransformer());
		
	}
	
}
