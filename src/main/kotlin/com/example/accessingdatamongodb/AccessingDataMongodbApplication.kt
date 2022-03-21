package com.example.accessingdatamongodb

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AccessingDataMongodbApplication{

	@Bean
	fun run(repository: CustomerRepository): CommandLineRunner {
		return CommandLineRunner {
			repository.deleteAll()

			// save a couple of customers
			repository.save(Customer("Alice", "Smith"))
			repository.save(Customer("Bob", "Smith"))

			// fetch all customers
			println("Customers found with findAll()")
			println("------------------------------")
			repository.findAll().forEach { println(it) }
			println()

			// fetch an individual customer
			println("Customer found with findByFirstName('Alice'):")
			println("---------------------------------------------")
			println(repository.findByFirstName("Alice"))


			println("Customer found with findByLastName('Smith')")
			println("-------------------------------------------")
			repository.findAll().forEach { println(it) }
		}
	}
}


fun main(args: Array<String>) {
	runApplication<AccessingDataMongodbApplication>(*args)
}
