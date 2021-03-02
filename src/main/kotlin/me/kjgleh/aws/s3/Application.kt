package me.kjgleh.aws.s3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
//@PropertySources(
//    PropertySource("classpath:application.yml"),
//    PropertySource("classpath:aws.yml")
//)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

