package com.example.elasticsearch.domain.entity

import com.example.elasticsearch.common.BaseEntity
import com.example.elasticsearch.domain.dto.BasicDto
import jakarta.persistence.*

@Entity
@Table(name = "basic")
@AttributeOverride(name = "id", column = Column(name = "basic_id"))
class Basic(
    var content: String? = null,
    
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "sub_id")
    var subBasic: SubBasic
): BaseEntity() {

    companion object {
        fun createNew(dto: BasicDto): Basic {
            return Basic(
                content = dto.content,
                subBasic = SubBasic.createNew(dto.subBasic!!)
            )
        }
    }
}