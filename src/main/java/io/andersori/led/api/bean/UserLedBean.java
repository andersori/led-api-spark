package io.andersori.led.api.bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.entity.UserLed;

public class UserLedBean implements BeanLed<UserLed> {
	
	private Long id;
	private String name;
	private String username;
	private String password;
	private LocalDateTime lastLogin;
	private Set<RoleLed> roles;
	
	public UserLedBean() {
		roles = new HashSet<RoleLed>(Arrays.asList(RoleLed.NONE));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Set<RoleLed> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleLed> roles) {
		this.roles = roles;
	}

	@Override
	public void toBean(Optional<UserLed> entity) {
		
		if(entity.isPresent()) {
			UserLed e = entity.get();
			this.setId(e.getId());
			this.setLastLogin(e.getLastLogin());
			this.setName(e.getName());
			this.setPassword(e.getPassword());
			this.setRoles(e.getRoles());
			this.setUsername(e.getUsername());
		}
		
	}

	@Override
	public UserLed toEntity() {
		UserLed entity = new UserLed();
		entity.setId(this.getId());
		entity.setLastLogin(this.getLastLogin());
		entity.setName(this.getName());
		entity.setPassword(this.getPassword());
		entity.setRoles(this.getRoles());
		entity.setUsername(this.getUsername());
		return entity;
	}
	
}