package com.interview.video.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factortypes")
public class FactorType {

	@Id
	@GeneratedValue
	private Long factortypeid;

	private String factor;
	private String factortype;
	private float score;

	public Long getFactortypeid() {
		return factortypeid;
	}

	public void setFactortypeid(Long factortypeid) {
		this.factortypeid = factortypeid;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getFactortype() {
		return factortype;
	}

	public void setFactortype(String factortype) {
		this.factortype = factortype;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
