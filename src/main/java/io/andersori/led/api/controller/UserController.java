package io.andersori.led.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import io.andersori.led.api.service.IUserService;
import io.andersori.led.api.util.JsonTransformer;
import spark.Spark;

import static io.andersori.led.api.security.SecurityConstants.PROTECTED_PATH;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("UserService")
	private IUserService userService;

	private final String PATH = PROTECTED_PATH + "/users";
	
	public UserController() {
		
		Spark.get(PATH, (req, res) -> {
			return userService.getUsers();
		}, new JsonTransformer());
		
	}
	
}
