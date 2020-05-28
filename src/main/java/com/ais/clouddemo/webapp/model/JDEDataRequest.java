package com.ais.clouddemo.webapp.model;

import java.util.List;
import java.util.Map;

public class JDEDataRequest {
	private String token;
	private String deviceName;
	private String targetName;
	private String targetType;
	private String dataServiceType;
	private Aggregation aggregation;
	private Map<String, List<ConditionItem>> having;
	
	
	public Aggregation getAggregation() {
		return aggregation;
	}
	public void setAggregation(Aggregation aggregation) {
		this.aggregation = aggregation;
	}
	public Map<String, List<ConditionItem>> getHaving() {
		return having;
	}
	public void setHaving(Map<String, List<ConditionItem>> having) {
		this.having = having;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getDataServiceType() {
		return dataServiceType;
	}
	public void setDataServiceType(String dataServiceType) {
		this.dataServiceType = dataServiceType;
	}
	
	public String toString() {
		return "[JDEDataRequest " + token + ", " + deviceName + ", " + targetName + " ... ]";
	}

}
