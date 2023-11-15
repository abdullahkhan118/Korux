package com.horux.microservices.authenticate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthenticationsApplication

fun main(args: Array<String>) {
	runApplication<AuthenticationsApplication>(*args)
}
