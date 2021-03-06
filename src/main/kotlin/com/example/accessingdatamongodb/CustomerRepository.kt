package com.example.accessingdatamongodb

import org.springframework.data.mongodb.repository.MongoRepository

@Suppress("unused")
interface CustomerRepository : MongoRepository<Customer, String> {

    fun findByFirstName(firstName: String): Customer
    fun findByLastName(lastName: String): List<Customer>
}