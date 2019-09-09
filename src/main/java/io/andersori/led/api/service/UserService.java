package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.UserLedDto;
import io.andersori.led.api.entity.UserLed;
import io.andersori.led.api.repository.UserRepositoryIn;

@Service("UserService")
public class UserService implements IUserService {
	
	@Autowired
	@Qualifier("UserRepositoryIm")
	private UserRepositoryIn userRepository;

	@Override
	public void register(UserLedDto user) {
		userRepository.save(user.toEntity(user));
	}

	@Override
	public List<UserLedDto> getUsers() {
		return userRepository.findAll()
		.stream()
		.map((UserLed u) -> {
			UserLedDto bean = new UserLedDto();
			return bean.toDto(u);
		})
		.collect(Collectors.toList());
	}

	@Override
	public Optional<UserLedDto> get(Long id) {
		Optional<UserLed> result = userRepository.get(id);
		
		if(result.isPresent()){
			UserLedDto bean = new UserLedDto();
			return Optional.of(bean.toDto(result.get()));
		}

		return Optional.empty();
	}
	
}
