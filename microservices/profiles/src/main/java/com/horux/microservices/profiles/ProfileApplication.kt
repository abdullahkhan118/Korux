package com.horux.microservices.profiles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = ["com.horux.*"])
class ProfileApplication

fun main(args: Array<String>) {
    runApplication<ProfileApplication>(*args)
}
