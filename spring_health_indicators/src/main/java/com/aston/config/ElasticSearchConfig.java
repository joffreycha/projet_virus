package com.aston.config;

import java.net.UnknownHostException;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticSearchConfig {

	@Bean
	public RestHighLevelClient client() throws UnknownHostException {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				.connectedTo("localhost:9200", "localhost:9300").withBasicAuth(login, password)
				.build();

		return RestClients.create(clientConfiguration).rest();
	}
	
	@Value("${spring.elasticsearch.rest.username}")
	private String login;
	
	@Value("${spring.elasticsearch.rest.password}")
	private String password;
}
