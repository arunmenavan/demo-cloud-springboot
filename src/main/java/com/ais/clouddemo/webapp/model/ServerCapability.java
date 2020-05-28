package com.ais.clouddemo.webapp.model;

public class ServerCapability {
	private String name;
	private String shortDescription;
	private String longDescription;
	private String asOfRelease;
	private String sinceVersion;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getAsOfRelease() {
		return asOfRelease;
	}
	public void setAsOfRelease(String asOfRelease) {
		this.asOfRelease = asOfRelease;
	}
	public String getSinceVersion() {
		return sinceVersion;
	}
	public void setSinceVersion(String sinceVersion) {
		this.sinceVersion = sinceVersion;
	}

	@Override
	public String toString() {
		return name + ", " + shortDescription + ", " + longDescription;
	}

}
