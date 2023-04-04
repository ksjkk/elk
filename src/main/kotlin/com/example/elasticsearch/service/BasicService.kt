package com.example.elasticsearch.service

import com.example.elasticsearch.domain.document.TestTableDocument
import com.example.elasticsearch.domain.dto.TestTableDto
import com.example.elasticsearch.domain.entity.TestTableEntity
import com.example.elasticsearch.repository.TestTableRepository
import com.example.elasticsearch.repository.TestTableSearchRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BasicService(
    private val testTableRepository: TestTableRepository,
    private val testTableSearchRepository: TestTableSearchRepository
) {
    
    @Transactional
    fun createWithSearch(dto: TestTableDto): TestTableDto {
        val newEntity = testTableRepository.save(
            TestTableEntity.createNew(dto)
        )
        testTableSearchRepository.save(
            TestTableDocument.from(newEntity)
        )
        return TestTableDto.from(newEntity)
    }
}