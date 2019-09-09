package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;

import io.andersori.led.api.dto.UserLedDto;

public interface IUserService extends Service<UserLedDto> {
	
	public void register(UserLedDto user);
	
	public List<UserLedDto> getUsers();

	public Optional<UserLedDto> getUser(String username);
	
}
