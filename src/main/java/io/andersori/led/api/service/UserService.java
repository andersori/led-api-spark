package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.entity.UserLed;
import io.andersori.led.api.repository.UserRepositoryIn;

@Service("UserService")
public class UserService implements IUserService {
	
	@Autowired
	@Qualifier("UserRepositoryIm")
	private UserRepositoryIn userRepository;

	@Override
	public void register(UserLedBean user) {
		userRepository.save(user.toEntity());
	}

	@Override
	public List<UserLedBean> getUsers() {
		return userRepository.findAll()
		.stream()
		.map((UserLed u) -> {
			UserLedBean bean = new UserLedBean();
			bean.toBean(Optional.of(u));
			return bean;
		})
		.collect(Collectors.toList());
	}

	@Override
	public Optional<UserLedBean> get(Long id) {
		Optional<UserLed> result = userRepository.get(id);
		
		if(result.isPresent()){
			UserLedBean bean = new UserLedBean();
			bean.toBean(result);
			return Optional.of(bean);
		}

		return Optional.empty();
	}

	@Override
	public Optional<UserLedBean> getUser(String username) {
		Optional<UserLed> user = userRepository.findByUsername(username);
		if(user.isPresent()){
			UserLedBean bean = new UserLedBean();
			bean.toBean(user);
			return Optional.of(bean);
		}
		return Optional.empty();
	}
	
}
