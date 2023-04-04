package com.example.elasticsearch.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.sql.DataSource
import kotlin.collections.HashMap

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(basePackages = ["com.example.elasticsearch"])
@EntityScan(basePackages = ["com.example.elasticsearch"])
class JpaConfig {
    
    @Bean
    @ConfigurationProperties("spring.jpa.properties.hibernate")
    fun hibernateProperties(): Map<String, Any> = HashMap()
    
    @Bean
    fun entityManagerFactory(dataSource: DataSource, hibernateProperties: Map<String, Any>): LocalContainerEntityManagerFactoryBean {
        return LocalContainerEntityManagerFactoryBean().also {
            it.dataSource = dataSource
            it.setPackagesToScan("com.example.elasticsearch")
            it.jpaVendorAdapter = HibernateJpaVendorAdapter()
            it.setJpaPropertyMap(hibernateProperties.entries.associate { property ->
                "hibernate.${property.key}" to property.value
            })
        }
    }
    
    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager? {
        return JpaTransactionManager().also {
            it.entityManagerFactory = entityManagerFactory
        }
    }
}

@Component
class AuditorAware: AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.of("user")
    }
}