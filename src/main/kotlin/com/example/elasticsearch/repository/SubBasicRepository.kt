package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.entity.SubBasic
import org.springframework.data.jpa.repository.JpaRepository

interface SubBasicRepository : JpaRepository<SubBasic, Long> {
}