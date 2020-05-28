package com.ais.clouddemo.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ais.clouddemo.webapp.model.JDEResource;
import com.ais.clouddemo.webapp.service.JDEDataService;

@Controller
public class JDEDataController {
	@Autowired
	public JDEDataService jdeDataService;
	
	public void setJdeDataService(JDEDataService jdeDataService) {
		this.jdeDataService = jdeDataService;
	}

	@RequestMapping("/showDataRequestPage")
	public String showRequestPage() {
		return "request-page";
	}
	
	@RequestMapping("/processServerDetailsRequest")
	public String processServerDetailsReqeust(HttpServletRequest reqeust, Model model) throws Exception  {
		JDEResource resResource = jdeDataService.findByName("defaultconfig");
		model.addAttribute("resBody", resResource.getHttpResponseBody());
		model.addAttribute("resCode",resResource.getHttpResponseCode());
		model.addAttribute("serverConfig",resResource.getServerConfig());
		return "receiveddata";
	}
	
	@RequestMapping("/processJDEDataRequest")
	public String processJDEDataReqeust(HttpServletRequest reqeust, Model model) throws Exception {
		
		String requestedResourceName = reqeust.getParameter("resourceName");
		JDEResource resResource = jdeDataService.findByName(requestedResourceName);
		model.addAttribute("resBody", resResource.getHttpResponseBody());
		model.addAttribute("resCode",resResource.getHttpResponseCode());
		return "receiveddata";
		
	}
	
	@RequestMapping("/processAggregateAPIRequest")
	public String processAggregateAPIReqeust(HttpServletRequest reqeust, Model model) throws Exception {
		
		JDEResource resResource = jdeDataService.findByName("dataservice");
		model.addAttribute("resBody", resResource.getHttpResponseBody());
		model.addAttribute("resCode",resResource.getHttpResponseCode());
		return "receiveddata-aggregationAPI";
		
	}

}

