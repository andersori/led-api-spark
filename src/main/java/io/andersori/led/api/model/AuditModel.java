package io.andersori.led.api.model;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditableListener.class)
public abstract class AuditModel {
	
	private String createdBy;
	private String lastModifieldBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public AuditModel() {
		
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifieldBy() {
		return lastModifieldBy;
	}

	public void setLastModifieldBy(String lastModifieldBy) {
		this.lastModifieldBy = lastModifieldBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
