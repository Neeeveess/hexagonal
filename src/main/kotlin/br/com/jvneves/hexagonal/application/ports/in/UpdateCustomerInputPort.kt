package br.com.jvneves.hexagonal.application.ports.`in`

import br.com.jvneves.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}