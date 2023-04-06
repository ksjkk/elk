package com.example.elasticsearch.domain.entity

import com.example.elasticsearch.common.BaseEntity
import com.example.elasticsearch.domain.dto.SubBasicDto
import com.example.elasticsearch.domain.entity.Basic
import jakarta.persistence.*

@Entity
@Table(name = "sub_basic")
@AttributeOverride(name = "id", column = Column(name = "sub_basic_id"))
class SubBasic(
    var content: String? = null
): BaseEntity() {
    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "subBasic")
//    var basic: Basic? = null
    
    
    companion object {
        fun createNew(dto: SubBasicDto): SubBasic {
            return SubBasic(
                content = dto.content
            )
        }
    }
}