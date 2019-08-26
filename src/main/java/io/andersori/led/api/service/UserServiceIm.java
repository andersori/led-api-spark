package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.repository.UserRepositoryIn;

@Service("UserServiceIm")
public class UserServiceIm implements UserServiceIn {
	
	@Autowired
	@Qualifier("UserReposotoryIm")
	private UserRepositoryIn userRepository;

	@Override
	public void register(UserLedBean user) {
		userRepository.save(user.toEntity());
	}

	@Override
	public List<UserLedBean> getUsers() {
		
		return userRepository.findAll()
				.stream()
				.map(u -> {
					UserLedBean bean = new UserLedBean();
					bean.toBean(Optional.of(u));
					return bean;
					})
				.collect(Collectors.toList());
		
	}
	
}
