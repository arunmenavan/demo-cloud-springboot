package com.ais.clouddemo.webapp.model;

public class AggregateAPIResponse {
	
	private FO60116Aggregation ds_F060116;
	private boolean deprecated;
	
	
	
	public FO60116Aggregation getDs_F060116() {
		return ds_F060116;
	}



	public void setDs_F060116(FO60116Aggregation ds_F060116) {
		this.ds_F060116 = ds_F060116;
	}



	public boolean isDeprecated() {
		return deprecated;
	}



	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}



	public String toString() {
		return ds_F060116.toString() + ", deprecated " + deprecated;
	}

}
