package br.com.jvneves.hexagonal.application.ports.`in`

import br.com.jvneves.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}