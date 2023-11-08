package com.horux.korux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KoruxApplication

fun main(args: Array<String>) {
    runApplication<KoruxApplication>(*args)
}
