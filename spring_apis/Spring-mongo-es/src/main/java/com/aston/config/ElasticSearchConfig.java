package com.aston.config;

import java.net.UnknownHostException;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticSearchConfig {

	@Bean
	public RestHighLevelClient client() throws UnknownHostException {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				.connectedTo("localhost:9200", "localhost:9201")
				.build();

		return RestClients.create(clientConfiguration).rest();
	}
}
