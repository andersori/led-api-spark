package io.andersori.led.api.entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_led")
public class UserLed extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_led_id")
	private Long id;

	@Column(name = "name", nullable = false, length = 250)
	private String name;

	@Column(name = "username", nullable = false, unique = true, length = 200)
	private String username;

	@Column(name = "password", nullable = false, length = 70)
	private String password;

	@Column(name = "last_login", nullable = true)
	private LocalDateTime lastLogin;

	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER, targetClass = RoleLed.class)
	@CollectionTable(name = "role_led", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role", length = 25, nullable = false)
	private Set<RoleLed> roles;
	
	public UserLed() {
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
	
}
