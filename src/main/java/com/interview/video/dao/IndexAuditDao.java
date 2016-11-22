package com.interview.video.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.video.entity.IndexAudit;

public interface IndexAuditDao extends JpaRepository<IndexAudit, String> {

	public IndexAudit findByTransactionIdAndStatus(String transactionId, String status);

	public IndexAudit findByTransactionId(String id);

	public List<IndexAudit> findByDateBetween(Date pastDate, Date currentDate);

	public List<IndexAudit> findByDateLessThan(Date pastDate);

}
