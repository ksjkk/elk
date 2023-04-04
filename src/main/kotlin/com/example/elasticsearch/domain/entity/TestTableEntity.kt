package com.example.elasticsearch.domain.entity

import com.example.elasticsearch.domain.dto.TestTableDto
import jakarta.persistence.*

@Entity
@Table(name = "test_table")
class TestTableEntity(
    var name: String? = null,
    var value: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        protected set
    
    companion object {
        fun createNew(dto: TestTableDto): TestTableEntity {
            return TestTableEntity(
                name = dto.name,
                value = dto.value
            )
        }
    }
}