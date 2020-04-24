package com.evol.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestHighLevelClientBuilder {

    @Bean(name = "esClient")
    public RestHighLevelClient getEsClient() {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(
                        "47.96.79.161", 9200, "http")));
        return client;
    }
}
