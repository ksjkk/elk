package com.example.elasticsearch.domain.dto

import com.example.elasticsearch.domain.entity.TestTableEntity

data class TestTableDto(
    var id: Long = 0,
    var name: String? = null,
    var value: String? = null
) {
    companion object {
        fun from(entity: TestTableEntity): TestTableDto {
            return TestTableDto(
                id = entity.id,
                name = entity.name,
                value = entity.value
            )
        }
    }
}