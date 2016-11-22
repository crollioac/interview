package com.interview.video.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@EnableAsync
public class LogUtils {

	private Logger logger = LoggerFactory.getLogger("AppLogger");

	private Class<?> callingClass;
	
	

	public LogUtils(Class<?> c) {
		if(c == null) {
			callingClass = LogUtils.class;
		} else {
			callingClass = c;
		}
	}

	public void info(String message) {
		logger.info(callingClass.getName()+": " + message);
	}

	public void debug(String message) {
		logger.debug(callingClass.getName()+": " + message);
	}

	public void error(String message) {
		logger.error(callingClass.getName()+": " + message);
	}

	public void warn(String message) {
		logger.warn(callingClass.getName()+": " + message);
	}

	public Logger getLogger() {
		return logger;
	}

	public String getCurrentRequestId() {
		try {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			Object requestId = request.getAttribute("requestId");
			if(requestId != null) {
				return requestId.toString();
			}
		} catch(Exception e) {
		}
		return "No Id";
	}
	


	@Async
	public void logDataPushedToQueue(Map<String, Object> data, String source,String action) {
		
		info("Pushed " + data.size() + " items from " + source + " to rabbitMQ for " + action + " " + data.toString());

	}
	

	
	@Async
	public void logReceivedData(List<String> data, String source, String action){
		
		info("Received "+data.size()+" items from "+source+" for "+action +" " + data.toString());
	}
	
	@Async
	public void logReceivedData(String query){
		
		info("Received query "+query);
	}
	
	@Async
	public void logDeletedData(List<String>data, String index){
		
		info("Deleted "+data.toString()+" from "+ index);
	}


	@Async
	public void logRabbitMQReceivedData(Map<String,Object> rabbitmqData, String source){
		Map<String,Object> data = (Map<String,Object>)rabbitmqData.get("data");
		List<String> ids = new ArrayList<String>();
		for(Map.Entry<String,Object> entry : data.entrySet()){
			ids.add(entry.getKey());
		}
		info("Pushed "+ids.size()+" items from "+source+" to rabbitMQ" + data.toString());
	}

	@Async
	public void logUpsertedData(List<String> updatedIds, List<String> failedIds, String index){
		info("Upserted "+updatedIds.size()+" items to "+index+", ids = " + updatedIds.toString());
		if(failedIds.size() > 0){
			error("Failed inserting "+failedIds.size()+" items to " +index + ", ids = " +failedIds.toString());
		}
	}
	
	@Async
	public void logUpsertedDataWithTime(List<String> updatedIds, List<String> failedIds, String index,long timeInMiliSecs){
		info("Bulk Upsert took "+timeInMiliSecs+"ms "+"Upserted "+updatedIds.size()+" items to "+index+", ids = " + updatedIds.toString());
		if(failedIds.size() > 0){
			error("Failed inserting "+failedIds.size()+" items to " +index + ", ids = " +failedIds.toString());
		}
	}

	@Async
	public void logUpsertedDataWithStyleIds(List<String> updatedIds, List<String> failedIds,List<String> failedStyleIds, String index){
		debug("Upserted "+updatedIds.size()+" items to "+index+", ids = " + updatedIds.toString());
		
		if(failedIds.size() > 0){
			error("Failed inserting "+failedIds.size()+" items to " +index + ", ids = " +failedIds.toString() + "Failed style Ids : "+failedStyleIds.toString());
		}
	}
	
	@Async
	public void logUpsertedDataWithStyleIds(List<String> updatedIds, List<String> failedIds,List<String> failedStyleIds, String index, long timeInMiliSecs){
		info("Bulk Upsert took "+timeInMiliSecs+"ms "+"Upserted "+updatedIds.size()+" items to "+index+", ids = " + updatedIds.toString());
		if(failedIds.size() > 0){
			error("Failed inserting "+failedIds.size()+" items to " +index + ", ids = " +failedIds.toString() + "Failed style Ids : "+failedStyleIds.toString());
		}
	}
	@Async
	public void logUpsertedStyleDataInfo(List<String> updatedIds, List<String> failedIds, String index, long timeInMiliSecs) {
		info("Bulk Upsert took " + timeInMiliSecs + "ms " + "Upserted " + updatedIds.size() + " items to " + index
				+ ", ids = " + updatedIds.toString());
		if (failedIds.size() > 0) {
			error("Failed inserting " + failedIds.size() + " items to " + index + ", ids = " + failedIds.toString());
		}
	}
}
