package io.andersori.led.api.dto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.entity.UserLed;

@JsonIgnoreProperties({})
public class UserLedDto extends Dto<UserLed, UserLedDto> {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	@JsonProperty("lastLogin")
	private LocalDateTime lastLogin;

	@JsonProperty("roles")
	private Set<RoleLed> roles = new HashSet<RoleLed>(Arrays.asList(RoleLed.NONE));;
	
	public UserLedDto(Class<UserLed> sourceType, Class<UserLedDto> destinationType) {
		super(sourceType, destinationType);
	}

	public UserLedDto() {
		this(UserLed.class, UserLedDto.class);
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

}
