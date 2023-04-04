package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.document.TestTableDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface TestTableSearchRepository: ElasticsearchRepository<TestTableDocument, Long> {
    fun findByNameAndValue(name: String, value: String): List<TestTableDocument>
}