package io.andersori.led.api.model;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditableListener {
	
	@PrePersist
	public void preCreate(AuditModel model) {
		model.setCreatedAt(LocalDateTime.now());
		model.setUpdatedAt(LocalDateTime.now());
		//model.setCreatedBy();
	}
	
	@PreUpdate
	public void preUpdate(AuditModel model) {
		//model.setLastModifieldBy();
		model.setUpdatedAt(LocalDateTime.now());
	}
	
}
