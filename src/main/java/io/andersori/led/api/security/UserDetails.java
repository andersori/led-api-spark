package io.andersori.led.api.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.andersori.led.api.dto.UserLedDTO;
import io.andersori.led.api.service.IUserService;

@Component
public class UserDetails {
    
    @Autowired
    @Qualifier("UserService")
    private IUserService userService;

    public Optional<User> loadUserByUsername(String username) {
        Optional<UserLedDTO> result = userService.get(username);
        if(result.isPresent()){
            UserLedDTO dto = result.get();
            User user = new User(dto.getUsername(), dto.getPassword(), new ArrayList<>(dto.getRoles()));
            return Optional.of(user);
        }
        return Optional.empty();
    }

}