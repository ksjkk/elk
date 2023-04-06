package com.example.elasticsearch.domain.dto

import com.example.elasticsearch.domain.entity.SubBasic
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class SubBasicDto(
    var subBasicId: Long,
    var content: String? = null
) {
    companion object {
        fun from(entity: SubBasic): SubBasicDto {
            return SubBasicDto(
                subBasicId = entity.id,
                content = entity.content
            )
        }
    }
}