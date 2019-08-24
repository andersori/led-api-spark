package io.andersori.led.api.config;

import java.util.Optional;

@FunctionalInterface
public interface Auditor {
	
	Optional<String> getCurrentAuditor();
	
}
