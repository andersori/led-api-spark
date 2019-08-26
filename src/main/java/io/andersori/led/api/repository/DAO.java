package io.andersori.led.api.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	
	List<T> findAll();
	
	Optional<T> save(T value);
	
	Optional<T> get(Long id);
	
	Optional<T> update(T value);
	
	Optional<T> remove(T value);
	
}
