package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.entity.Basic
import org.springframework.data.jpa.repository.JpaRepository

interface BasicRepository: JpaRepository<Basic, Long> {
}