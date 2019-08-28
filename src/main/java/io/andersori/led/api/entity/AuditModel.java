package io.andersori.led.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import io.andersori.led.api.config.AuditorListener;

@MappedSuperclass
@EntityListeners(AuditorListener.class)
public abstract class AuditModel {

	@NotNull
	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;

	@NotNull
	@Column(name = "last_modifield_by", nullable = false)
	private String lastModifieldBy;

	@NotNull
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@NotNull
	@Column(name = "updated_at", nullable = false)
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
