package com.example.elasticsearch.api

import com.example.elasticsearch.domain.dto.BasicDto
import com.example.elasticsearch.domain.dto.TestTableDto
import com.example.elasticsearch.service.BasicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class BasicApi(
    private val service: BasicService
) {
    
    @PutMapping("/basic/create-with-search")
    fun createWithSearch(@RequestBody request: TestTableDto): TestTableDto {
        return service.createWithSearch(request)
    }
    
    @PutMapping("/basic")
    fun createBasic(@RequestBody request: BasicDto): BasicDto {
        return service.createBasic(request)
    }
    
    @GetMapping("/basic/{basicId}")
    fun getBasic(@PathVariable basicId: Long): BasicDto {
        return service.getBasic(basicId)
    }
    
    @GetMapping("/basic-call/{basicId}")
    fun callBasic(@PathVariable basicId: Long) {
        service.callBasic(basicId)
    }
}