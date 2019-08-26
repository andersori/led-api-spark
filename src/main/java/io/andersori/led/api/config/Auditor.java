package io.andersori.led.api.config;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component("Auditor")
public class Auditor {
	
	private static final String auditor = "led_auditor";
	
	public Optional<String> getCurrentAuditor() {
		return Optional.of(auditor);
	}
	
}
