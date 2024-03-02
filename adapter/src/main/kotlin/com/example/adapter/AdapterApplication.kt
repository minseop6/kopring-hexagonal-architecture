package com.example.adapter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class AdapterApplication

fun main(args: Array<String>) {
    runApplication<AdapterApplication>(*args)
}