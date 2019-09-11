package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;

import io.andersori.led.api.dto.UserLedDTO;

public interface IUserService extends Service<UserLedDTO> {
	
	public void register(UserLedDTO user);
	
	public List<UserLedDTO> getUsers();

	public Optional<UserLedDTO> get(String username);
	
}
