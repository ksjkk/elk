package com.example.elasticsearch.service

import com.example.elasticsearch.common.logger
import com.example.elasticsearch.common.unwrap
import com.example.elasticsearch.domain.document.TestTableDocument
import com.example.elasticsearch.domain.dto.BasicDto
import com.example.elasticsearch.domain.dto.TestTableDto
import com.example.elasticsearch.domain.entity.Basic
import com.example.elasticsearch.domain.entity.TestTableEntity
import com.example.elasticsearch.repository.BasicRepository
import com.example.elasticsearch.repository.TestTableRepository
import com.example.elasticsearch.repository.TestTableSearchRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BasicService(
    private val basicRepository: BasicRepository,
    private val testTableRepository: TestTableRepository,
    private val testTableSearchRepository: TestTableSearchRepository
) {
    private val log = logger()
    
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
    
    @Transactional
    fun createBasic(dto: BasicDto): BasicDto {
        return BasicDto.from(basicRepository.save(Basic.createNew(dto)))
    }
    
    @Transactional
    fun getBasic(basicId: Long): BasicDto {
        return BasicDto.from(
            basicRepository.findById(basicId).unwrap().also {
                log.info("entity : {}", it)
            }
        )
    }
    @Transactional
    fun callBasic(basicId: Long) {
        basicRepository.findById(basicId).unwrap().let {
            log.info("entity : {}", it)
        }
    }
}