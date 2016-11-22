package com.interview.utils;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.interview.dao.IndexAuditDao;
import com.interview.entity.IndexAudit;

@Service
public class DBUtils {
	
	@Autowired
	IndexAuditDao auditRepository;

	@Async
	public void logToAuditTable(String transactionId, String source, String data, Integer count, String status) {		
		IndexAudit audit = new IndexAudit();
		audit.setTransactionId(transactionId);
		audit.setSource(source);
		audit.setData(data);
		audit.setDocumentCount(count);
		audit.setDate(new Date());
		audit.setStatus(status);
		auditRepository.save(audit);
	}
	
	@Async
	public void logToAuditTable(String transactionId, String source, String data, Integer count, String status, List<String> failedIds, List<String> indexedIds, String message) {

		IndexAudit audit = new IndexAudit();
		audit.setTransactionId(transactionId);
		audit.setSource(source);
		audit.setData(data);
		audit.setDocumentCount(count);
		audit.setDate(new Date());
		audit.setStatus(status);
		audit.setFailedIds(GenericUtils.toString(failedIds));
		audit.setIndexedIds(GenericUtils.toString(indexedIds));
		audit.setMessage(message);
		auditRepository.save(audit);
	}

	public IndexAudit getTaskStatus(String transactionId, String status) {
		return auditRepository.findByTransactionIdAndStatus(transactionId, status);
	}
}
