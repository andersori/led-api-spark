package io.andersori.led.api.config;

public class Auditor {
	
	private static final ThreadLocal<String> userContex = new ThreadLocal<String>(){

		@Override
		protected String initialValue(){
			return "led_default_auditor";
		}
		
	};

	public static void setUser(String username) {
		userContex.set(username);
	}
	
	public static String getUser() {
		return userContex.get();
	}
	
}
