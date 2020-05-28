package com.ais.clouddemo.webapp.util;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	private static final Logger LOGGER=LoggerFactory.getLogger(RestTemplateConfig.class);
	
	// SSL Certificate validation and host name validation are disabled in the insecure access. This is only for the connections in the development environment
	@Bean
	public RestTemplate restTemplateInSecure() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
            LOGGER.debug("*** RestTemplate has been created!");
    		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
 
    		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                    		.loadTrustMaterial(null, acceptingTrustStrategy)
                    		.build();
 
    		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
 
    		CloseableHttpClient httpClient = HttpClients.custom()
                    		.setSSLSocketFactory(csf)
                    		.build();
 
    		HttpComponentsClientHttpRequestFactory requestFactory =
                    		new HttpComponentsClientHttpRequestFactory();
 
    		requestFactory.setHttpClient(httpClient);
    		RestTemplate restTemplate = new RestTemplate(requestFactory);
   		return restTemplate;
 	}

}
