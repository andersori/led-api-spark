package io.andersori.led.api.config;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import io.andersori.led.api.entity.AuditModel;
import io.andersori.led.api.util.BeanUtil;

@Component
public class AuditorListener {
	
	@PrePersist
	private void onPrePersist(AuditModel model) {
		Auditor auditor = BeanUtil.getBean(Auditor.class);

		model.setCreatedAt(LocalDateTime.now());
		model.setUpdatedAt(LocalDateTime.now());
		model.setCreatedBy(auditor.getCurrentAuditor().get());
		model.setLastModifieldBy(auditor.getCurrentAuditor().get());
	}
	
	@PreUpdate
	private void onPreUpdate(AuditModel model) {
		Auditor auditor = BeanUtil.getBean(Auditor.class);

		model.setUpdatedAt(LocalDateTime.now());
		model.setLastModifieldBy(auditor.getCurrentAuditor().get());
	}
	
}
