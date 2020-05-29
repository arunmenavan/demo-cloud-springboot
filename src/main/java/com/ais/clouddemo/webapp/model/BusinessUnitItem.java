package com.ais.clouddemo.webapp.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class BusinessUnitItem {
	
	private Map<String, String> groupBy;
	//private String F060116.SAL_AVG;
	private int count;
	
	Map<String, Object> details = new LinkedHashMap<>();
	 
    @JsonAnySetter
    void setDetail(String key, Object value) {
        details.put(key, value);
    }
	

	public Map<String, Object> getDetails() {
		return details;
	}


	public Map<String, String> getGroupBy() {
		return groupBy;
	}


	public void setGroupBy(Map<String, String> groupBy) {
		this.groupBy = groupBy;
	}




	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}


	@Override
	public String toString() {
		return groupBy.toString() + ", " + count + ", " + details.toString();
	}
	

}
