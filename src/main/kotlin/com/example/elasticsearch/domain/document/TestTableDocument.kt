package com.example.elasticsearch.domain.document

import com.example.elasticsearch.domain.entity.TestTableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "test_tables")
class TestTableDocument(
    
    @Id
    @field:Field(type = FieldType.Keyword)
    var id: Long = 0,
    
    @field:Field(type = FieldType.Text)
    var name: String? = null,

    @field:Field(type = FieldType.Text)
    var value: String? = null,
) {
    
    companion object {
        fun from(entity: TestTableEntity): TestTableDocument {
            return TestTableDocument(
                id = entity.id,
                name = entity.name,
                value = entity.value
            )
        }
    }
}