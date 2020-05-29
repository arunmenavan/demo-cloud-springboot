package com.ais.clouddemo.webapp.model;

public class JDEResource {
	private String name;
	private String httpRequestHeader;
	private String httpRequestBody;
	private String httpResponseCode;
	private String httpResponseBody;
	private ServerConfig serverConfig;
	private AggregateAPIResponse aggregateAPIResponse;
	
	
	public AggregateAPIResponse getAggregateAPIResponse() {
		return aggregateAPIResponse;
	}


	public void setAggregateAPIResponse(AggregateAPIResponse aggregateAPIResponse) {
		this.aggregateAPIResponse = aggregateAPIResponse;
	}


	public ServerConfig getServerConfig() {
		return serverConfig;
	}


	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHttpRequestHeader() {
		return httpRequestHeader;
	}


	public void setHttpRequestHeader(String httpRequestHeader) {
		this.httpRequestHeader = httpRequestHeader;
	}


	public String getHttpRequestBody() {
		return httpRequestBody;
	}


	public void setHttpRequestBody(String httpRequestBody) {
		this.httpRequestBody = httpRequestBody;
	}


	public String getHttpResponseCode() {
		return httpResponseCode;
	}


	public void setHttpResponseCode(String httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}


	public String getHttpResponseBody() {
		return httpResponseBody;
	}


	public void setHttpResponseBody(String httpResponseBody) {
		this.httpResponseBody = httpResponseBody;
	}


	@Override
	public String toString() {
		return " Data from JDE for "+ name +" is "+ httpRequestBody;
	}


}
