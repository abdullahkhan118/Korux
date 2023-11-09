package com.horux.database_management.interfaces.database_properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/*
    Database Configuration for PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
    spring.datasource.username=youruser
    spring.datasource.password=yourpassword
    spring.datasource.driver-class-name=org.postgresql.Driver
*/


abstract class DatabaseProperties {
    abstract val url: String
    abstract val username: String
    abstract val password: String
    abstract val driverClassName: String
    abstract val dialect: String
}
open class PostgresProperties(
    override val url: String = "jdbc:postgresql://localhost:5432/mydatabase",
    override val username: String = "admin",
    override val password: String = "admin",
    override val driverClassName: String = "org.postgresql.Driver",
    override val dialect: String = "org.hibernate.dialect.PostgreSQLDialect"
): DatabaseProperties()