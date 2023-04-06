package com.example.elasticsearch.domain.dto

import com.example.elasticsearch.domain.entity.Basic
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BasicDto(
    var basicId: Long = 0,
    var content: String? = null,
    var subBasic: SubBasicDto? = null
) {
    companion object {
        fun from(entity: Basic): BasicDto {
            return BasicDto(
                basicId = entity.id,
                content = entity.content,
                subBasic = SubBasicDto.from(entity.subBasic)
            )
        }
    }
}
