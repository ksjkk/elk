package com.example.elasticsearch.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.util.*

fun <T> Optional<T>.unwrap(): T {
    return this.orElseThrow { IllegalArgumentException("data not exist") }
}

fun <T> T?.unwrap(): T {
    return this ?: throw IllegalArgumentException("data not exist")
}

inline fun <reified T> T.logger(): Logger = LoggerFactory.getLogger(T::class.java)