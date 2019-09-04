package io.andersori.led.api.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.UserLed;

@Repository("UserRepositoryIm")
public class UserRepositoryIm extends DAOHibernate<UserLed> implements UserRepositoryIn {

	protected UserRepositoryIm(Class<UserLed> type) {
		super(type);
	}
	
	public UserRepositoryIm() {
		this(UserLed.class);
	}

	@Override
	public Optional<UserLed> findByUsername(String username) {
		return null;
	}

}
