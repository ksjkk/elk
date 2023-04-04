package com.example.elasticsearch.api

import com.example.elasticsearch.domain.dto.TestTableDto
import com.example.elasticsearch.service.BasicService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class BasicApi(
    private val service: BasicService
) {
    
    @PutMapping("/basic/create-with-search")
    fun createWithSearch(@RequestBody request: TestTableDto): TestTableDto {
        return service.createWithSearch(request)
    }
}