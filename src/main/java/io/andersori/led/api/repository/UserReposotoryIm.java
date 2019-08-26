package io.andersori.led.api.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.UserLed;

@Repository("UserReposotoryIm")
public class UserReposotoryIm extends DAOHibernate<UserLed> implements UserRepositoryIn {

	protected UserReposotoryIm(Class<UserLed> type) {
		super(type);
	}
	
	public UserReposotoryIm() {
		this(UserLed.class);
	}

	@Override
	public Optional<UserLed> findByUsername(String username) {
		return null;
	}

}
