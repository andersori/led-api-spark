package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;

import io.andersori.led.api.bean.UserLedBean;

public interface UserServiceIn {
	
	public void register(UserLedBean user);
	
	public List<UserLedBean> getUsers();
	
	public Optional<UserLedBean> getUser(Long id);

}
