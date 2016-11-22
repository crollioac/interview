
package com.interview.video.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class IndexAudit {

	@Id
	@GeneratedValue
	private Long id;

	private String transactionId;
	private String source;
	private String status;
	private Integer documentCount;

	@Lob
	private String failedIds;

	@Lob
	private String indexedIds;

	@Lob
	private String message;

	@Lob
	private String data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDocumentCount() {
		return documentCount;
	}

	public void setDocumentCount(Integer documentCount) {
		this.documentCount = documentCount;
	}

	public String getFailedIds() {
		return failedIds;
	}

	public void setFailedIds(String failedIds) {
		this.failedIds = failedIds;
	}

	public String getIndexedIds() {
		return indexedIds;
	}

	public void setIndexedIds(String indexedIds) {
		this.indexedIds = indexedIds;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
