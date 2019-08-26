package io.andersori.led.api.config;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;

import io.andersori.led.api.entity.AuditModel;

public class AuditorListener {
	
	@Autowired
	private Auditor auditor;
	
	@PrePersist
	private void onPrePersist(AuditModel model) {
		model.setCreatedAt(LocalDateTime.now());
		model.setUpdatedAt(LocalDateTime.now());
		model.setCreatedBy(auditor.getCurrentAuditor().get());
		model.setLastModifieldBy(auditor.getCurrentAuditor().get());
	}
	
	@PreUpdate
	private void onPreUpdate(AuditModel model) {
		model.setUpdatedAt(LocalDateTime.now());
		model.setLastModifieldBy(auditor.getCurrentAuditor().get());
	}
	
}
