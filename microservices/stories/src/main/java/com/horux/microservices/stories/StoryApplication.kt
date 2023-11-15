package com.horux.microservices.stories

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = ["com.horux.*"])
class StoryApplication

fun main(args: Array<String>){
    runApplication<StoryApplication>(*args)
}