package com.ais.clouddemo.webapp.model;

import java.util.List;
import java.util.Map;

public class Aggregation {
	
	private List<AggregationItem> aggregations; 
    private List<Map<String, String>> groupBy;
    private List<Map<String, String>> orderBy;
    
	public List<AggregationItem> getAggregations() {
		return aggregations;
	}
	public void setAggregations(List<AggregationItem> aggregations) {
		this.aggregations = aggregations;
	}
	public List<Map<String, String>> getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(List<Map<String, String>> groupBy) {
		this.groupBy = groupBy;
	}
	public List<Map<String, String>> getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(List<Map<String, String>> orderBy) {
		this.orderBy = orderBy;
	}
    
    @Override
	public String toString() {
    	return aggregations.toString() + ", " + groupBy.toString() + ", " + orderBy.toString();
    }
}
