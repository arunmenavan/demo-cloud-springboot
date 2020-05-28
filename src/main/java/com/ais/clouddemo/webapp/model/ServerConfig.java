package com.ais.clouddemo.webapp.model;

import java.util.List;

public class ServerConfig {
	private String jasHost;
	private String defaultEnvironment;
	private String defaultJasServer;
	private String aisVersion;
	private List<ServerCapability> capabilityList;
	private boolean requiredCapabilityMissing;

	
	public List<ServerCapability> getCapabilityList() {
		return capabilityList;
	}


	public void setCapabilityList(List<ServerCapability> capabilityList) {
		this.capabilityList = capabilityList;
	}


	public String getJasHost() {
		return jasHost;
	}


	public void setJasHost(String jasHost) {
		this.jasHost = jasHost;
	}




	public String getDefaultJasServer() {
		return defaultJasServer;
	}


	public void setDefaultJasServer(String defaultJasServer) {
		this.defaultJasServer = defaultJasServer;
	}


	public String getAisVersion() {
		return aisVersion;
	}


	public void setAisVersion(String aisVersion) {
		this.aisVersion = aisVersion;
	}




	public boolean isRequiredCapabilityMissing() {
		return requiredCapabilityMissing;
	}


	public void setRequiredCapabilityMissing(boolean requiredCapabilityMissing) {
		this.requiredCapabilityMissing = requiredCapabilityMissing;
	}


	public String toString() {
		return jasHost + ", " + defaultEnvironment;
	}


	public String getDefaultEnvironment() {
		return defaultEnvironment;
	}


	public void setDefaultEnvironment(String defaultEnvironment) {
		this.defaultEnvironment = defaultEnvironment;
	}

}
