package com.ais.clouddemo.webapp.util;

public enum Resource {
	DEFAULTCONFIG("defaultconfig"),
	DATASERVICE("dataservice"),
	TOKENREQUEST("tokenrequest");
	
private final String name;
	Resource (String name) {
		this.name=name;
	}
	public String getResourceName() {
		return this.name;
	}
}
