package com.example.elasticsearch.config

import com.example.elasticsearch.common.logger
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
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

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(basePackages = ["com.example.elasticsearch"])
class JpaConfig {
    private val log = logger()
    
    @Bean
    fun entityManagerFactory(dataSource: DataSource, jpaProperties: JpaProperties): LocalContainerEntityManagerFactoryBean {
        return LocalContainerEntityManagerFactoryBean().also {
            it.dataSource = dataSource
            it.setPackagesToScan("com.example.elasticsearch")
            it.jpaVendorAdapter = HibernateJpaVendorAdapter()
            it.setJpaPropertyMap(jpaProperties.properties)
        }
    }
    
    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
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