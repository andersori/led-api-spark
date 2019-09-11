package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.UserLedDTO;
import io.andersori.led.api.entity.UserLed;
import io.andersori.led.api.repository.UserRepositoryIn;

@Service("UserService")
public class UserService implements IUserService {
	
	@Autowired
	@Qualifier("UserRepositoryIm")
	private UserRepositoryIn userRepository;

	@Override
	public void register(UserLedDTO user) {
		userRepository.save(user.toEntity(user));
	}

	@Override
	public List<UserLedDTO> getUsers() {
		return userRepository.findAll()
		.stream()
		.map((UserLed u) -> {
			UserLedDTO bean = new UserLedDTO();
			return bean.toDto(u);
		})
		.collect(Collectors.toList());
	}

	@Override
	public Optional<UserLedDTO> get(Long id) {
		Optional<UserLed> result = userRepository.get(id);
		
		if(result.isPresent()){
			UserLedDTO bean = new UserLedDTO();
			return Optional.of(bean.toDto(result.get()));
		}

		return Optional.empty();
	}

	@Override
	public Optional<UserLedDTO> getUser(String username) {
		Optional<UserLed> user = userRepository.findByUsername(username);
		if(user.isPresent()){
			UserLedDTO bean = new UserLedDTO();
			return Optional.of(bean.toDto(user.get()));
		}
		return Optional.empty();
	}
	
}
