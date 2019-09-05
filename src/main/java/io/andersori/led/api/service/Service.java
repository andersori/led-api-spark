package io.andersori.led.api.service;

import java.util.Optional;

public interface Service<T> {

    Optional<T> get(Long id);
    
}