package com.ais.clouddemo.webapp.model;

import java.util.List;
import java.util.Map;

public class ConditionItem {
	
	private List<Map<String, String>> value;
	private String controlId;
	private String operator;
	private String aggregation;
	public List<Map<String, String>> getValue() {
		return value;
	}
	public void setValue(List<Map<String, String>> value) {
		this.value = value;
	}
	public String getControlId() {
		return controlId;
	}
	public void setControlId(String controlId) {
		this.controlId = controlId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAggregation() {
		return aggregation;
	}
	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}
	
	@Override
    public String toString() {
    	return value.toString() + ", " + controlId + ", " + operator + ", " + aggregation;
    }
}
