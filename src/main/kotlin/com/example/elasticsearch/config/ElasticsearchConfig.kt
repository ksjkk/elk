package com.example.elasticsearch.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories


@Configuration
@EnableElasticsearchRepositories("com.example.elasticsearch")
class ElasticsearchConfig : ElasticsearchConfigurationSupport()