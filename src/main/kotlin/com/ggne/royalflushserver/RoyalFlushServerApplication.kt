package com.ggne.royalflushserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class RoyalFlushServerApplication

fun main(args: Array<String>) {
	runApplication<RoyalFlushServerApplication>(*args)
}
