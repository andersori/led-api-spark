package io.andersori.led.api.repository;

import java.util.Optional;

import io.andersori.led.api.entity.UserLed;

public interface UserRepositoryIn extends DAO<UserLed> {
	
	public Optional<UserLed> findByUsername(String username);
	
}
