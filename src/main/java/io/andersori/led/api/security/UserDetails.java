package io.andersori.led.api.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.andersori.led.api.dto.UserLedDto;
import io.andersori.led.api.service.IUserService;

@Component
public class UserDetails {
    
    @Autowired
    @Qualifier("UserService")
    private IUserService userService;

    public Optional<User> loadUserByUsername(String username) {
        Optional<UserLedDto> result = userService.getUser(username);
        if(result.isPresent()){
            UserLedDto bean = result.get();
            User user = new User(bean.getUsername(), bean.getPassword(), new ArrayList<>(bean.getRoles()));
            return Optional.of(user);
        }
        return Optional.empty();
    }

}