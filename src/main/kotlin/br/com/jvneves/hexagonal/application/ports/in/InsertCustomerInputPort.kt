package br.com.jvneves.hexagonal.application.ports.`in`

import br.com.jvneves.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)

}