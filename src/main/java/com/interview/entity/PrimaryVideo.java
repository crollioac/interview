package com.interview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "primary_video")
public class PrimaryVideo {
	
	@Id
	@GeneratedValue
	private Long primaryId;

	@Column(name = "userid", nullable = false, length = 100)
	private Long userId;
	
	public Long getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(Long primaryId) {
		this.primaryId = primaryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
