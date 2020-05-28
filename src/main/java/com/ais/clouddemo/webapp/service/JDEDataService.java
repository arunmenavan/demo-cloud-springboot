package com.ais.clouddemo.webapp.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ais.clouddemo.webapp.model.Aggregation;
import com.ais.clouddemo.webapp.model.AggregationItem;
import com.ais.clouddemo.webapp.model.ConditionItem;
import com.ais.clouddemo.webapp.model.JDEDataRequest;
import com.ais.clouddemo.webapp.model.JDEResource;
import com.ais.clouddemo.webapp.model.ServerConfig;
import com.ais.clouddemo.webapp.util.Resource;
import com.ais.clouddemo.webapp.util.RestClient;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("jdeDataService")
public class JDEDataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JDEDataService.class);
	@Autowired
	public RestClient restClient;

	@Value("${server.host.name}")
	private String jdeServerHostName;

	@Value("${server.host.port}")
	private String jdeServerPort;

	@Value("${server.default.path}")
	private String jdeDefaultResourcePath;
	
	@Value("${jde.basicAuth.username}")
	private String userName;
	
	@Value("${jde.basicAuth.password}")
	private String password;
	
	@Value("${jde.clientID}")
	private String clientID;

	public JDEResource findByName(String resourceName) throws Exception {

		LOGGER.info(" ** Insdie findByName and resource name is {} ", resourceName);

		JDEResource resJDEResource = new JDEResource();
		String resourceEndPoint;
		String jsonbody = null;
		Map<String, String> responseMap = null;
		LOGGER.info(" resource name and Enum {} and {} ", resourceName, Resource.DEFAULTCONFIG.getResourceName());
		if (resourceName == null) {
			resJDEResource.setHttpResponseBody("Backend resource name is missing");
			resJDEResource.setHttpResponseCode("204");
			resJDEResource.setName(resourceName);
			return resJDEResource;
		} else if (resourceName.equalsIgnoreCase(Resource.DEFAULTCONFIG.getResourceName())) {
			resourceEndPoint = getBaseEndPoint() + Resource.DEFAULTCONFIG.getResourceName();
			
			LOGGER.info(" Get data from  {} for request {}", resourceEndPoint, jsonbody);
			responseMap = restClient.post(resourceEndPoint, jsonbody);
			ServerConfig serverConfig = readJSONServerConfig (responseMap.get("responseBody"));
			resJDEResource.setHttpResponseBody(responseMap.get("responseBody"));
			resJDEResource.setHttpResponseCode(responseMap.get("httpCode"));
			resJDEResource.setServerConfig(serverConfig);
			LOGGER.info(" *** Server Config Object {} ", serverConfig);
			
		} else if (resourceName.equalsIgnoreCase(Resource.DATASERVICE.getResourceName())) {
			resourceEndPoint = getBaseEndPoint() + Resource.DATASERVICE.getResourceName();
			String requestString = getJDEDataRequestJSON( getJDEDataRequest() );
			LOGGER.info(" Request "+ requestString);
			responseMap = restClient.post(resourceEndPoint, requestString);
	//		ServerConfig serverConfig = readJSONServerConfig (responseMap.get("responseBody"));
			resJDEResource.setHttpResponseBody(responseMap.get("responseBody"));
			resJDEResource.setHttpResponseCode(responseMap.get("httpCode"));

		} else if (resourceName.equalsIgnoreCase(Resource.TOKENREQUEST.getResourceName())) {
             String token = getAccessToken();
             LOGGER.info("Access token is {} ", token);
             resJDEResource.setHttpResponseBody(token);
             resJDEResource.setHttpResponseCode("NA");
     		resJDEResource.setName(resourceName);
		} else {
			resJDEResource.setHttpResponseBody("Resource name is not found in the backend");
			resJDEResource.setHttpResponseCode("204");
			resJDEResource.setName(resourceName);
			return resJDEResource;
		}

		//LOGGER.info(" Get data from  {} for request {}", resourceEndPoint, jsonbody);
		//Map<String, String> responseMap = restClient.post(resourceEndPoint, jsonbody);


		return resJDEResource;
	}

	private String getBaseEndPoint() {
		String baseendpoint = jdeServerHostName + ":" + jdeServerPort + "/" + jdeDefaultResourcePath + "/";
		return baseendpoint;
	}
	private JDEDataRequest getJDEDataRequest() throws KeyManagementException, JsonProcessingException, KeyStoreException, NoSuchAlgorithmException, IOException {
		AggregationItem aggregateItemOne = new AggregationItem();
		aggregateItemOne.setColumn("F060116.SAL");
		aggregateItemOne.setAggregation("AVG");
		
		AggregationItem aggregateItemTwo = new AggregationItem();
		aggregateItemTwo.setColumn("*");
		aggregateItemTwo.setAggregation("COUNT");
		
		
		List<AggregationItem> aggregationsList = new ArrayList<AggregationItem>();
		aggregationsList.add(aggregateItemOne);
		aggregationsList.add(aggregateItemTwo);
		Aggregation aggregation = new Aggregation();
		aggregation.setAggregations(aggregationsList);
		
		List<Map<String, String>> groupByList = new ArrayList<>();
		Map<String, String> groupByItem = new HashMap<>();
		groupByItem.put("column", "F060116.HMCU");
		groupByList.add(groupByItem);
		aggregation.setGroupBy(groupByList);
		
		List<Map<String, String>> orderByList = new ArrayList<>();
		Map<String, String> orderByItem = new HashMap<>();
		orderByItem.put("column", "F060116.SAL");
		orderByItem.put("aggregation", "AVG");
		orderByItem.put("direction", "DESC");
		orderByList.add(orderByItem);
		aggregation.setOrderBy(orderByList);
		
		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("content","50000");
		valueMap.put("specialValueId","LITERAL");
		List<Map<String, String>> valueList = new ArrayList<>();
		valueList.add(valueMap);
		
		ConditionItem conditionItem = new ConditionItem();
		conditionItem.setValue(valueList);
		conditionItem.setControlId("F060116.SAL");
		conditionItem.setOperator("GREATER");
		conditionItem.setAggregation("AVG");
		
		List<ConditionItem> conditionItemList = new ArrayList<>();
		conditionItemList.add(conditionItem);
		
		Map<String, List<ConditionItem>> having = new HashMap<>();
		having.put("condition", conditionItemList);
		
		JDEDataRequest dataRequestBean = new JDEDataRequest();
		dataRequestBean.setToken(getAccessToken());
		dataRequestBean.setDeviceName(clientID);
		dataRequestBean.setTargetName("F060116");
		dataRequestBean.setTargetType("table");
		dataRequestBean.setDataServiceType("AGGREGATION");
		dataRequestBean.setAggregation(aggregation);
		dataRequestBean.setHaving(having);
		
		return dataRequestBean;
	}
	
	private String getJDEDataRequestJSON(JDEDataRequest dataRequestBean) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataRequestBean);
		return jsonString;
	}
	
	private ServerConfig readJSONServerConfig(String jsonResponse) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ServerConfig serverConfig = mapper.readValue(jsonResponse, ServerConfig.class);
		return serverConfig;
	}
	

	private String getAccessToken() throws JsonProcessingException, IOException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		String tokenString;
		String resourceEndPoint = getBaseEndPoint() + Resource.TOKENREQUEST.getResourceName();
		String jsonbody = "{\"username\": \"" + userName + "\",\"password\": \"" + password + "\",\"deviceName\": \"" + clientID + "\"}";
		Map<String, String> responseMap = restClient.post(resourceEndPoint, jsonbody);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(responseMap.get("responseBody"));
		tokenString = node.path("userInfo").path("token").asText();
		return tokenString;
	}


}
