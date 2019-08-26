package io.andersori.led.api.bean;

import java.util.Optional;

public interface BeanLed<T> {
	
	void toBean(Optional<T> entity);
	
	T toEntity();
	
}
