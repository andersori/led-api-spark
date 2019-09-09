package io.andersori.led.api.config;

import org.springframework.stereotype.Component;

@Component("Auditor")
public class Auditor {
	
	private static final ThreadLocal<String> userContex = new ThreadLocal<>(){

		@Override
		protected String initialValue(){
			return "led_default_auditor";
		}
		
	};

	public void setUser(String username) {
		userContex.set(username);
	}
	
	public String getUser() {
		return userContex.get();
	}
	
}
