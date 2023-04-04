package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.entity.TestTableEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TestTableRepository : JpaRepository<TestTableEntity, Long>