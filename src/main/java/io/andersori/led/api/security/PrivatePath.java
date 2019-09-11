package io.andersori.led.api.security;

public abstract class PrivatePath {
	
	private final String path;
	
	public PrivatePath(String path) {
		this.path = path;
	}

	public String getPath() {
		return SecurityConstants.PROTECTED_PATH_PREFIX + path;
	}
	
}
