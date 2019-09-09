package io.andersori.led.api.config;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import io.andersori.led.api.entity.AuditModel;

@Component
public class AuditorListener {
	
	@PrePersist
	private void onPrePersist(AuditModel model) {
		model.setCreatedAt(LocalDateTime.now());
		model.setUpdatedAt(LocalDateTime.now());
		model.setCreatedBy(Auditor.getUser());
		model.setLastModifieldBy(Auditor.getUser());
	}
	
	@PreUpdate
	private void onPreUpdate(AuditModel model) {
		model.setUpdatedAt(LocalDateTime.now());
		model.setLastModifieldBy(Auditor.getUser());
	}
	
}
