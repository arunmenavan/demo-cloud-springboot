package com.ais.clouddemo.webapp.model;

public class AggregationItem {
	private String column;
	private String aggregation;
	
	
	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}


	public String getAggregation() {
		return aggregation;
	}


	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}


	@Override
	public String toString() {
		return "AggregationItem [\" " + column + ". " + aggregation + " \"]";
	}

}
