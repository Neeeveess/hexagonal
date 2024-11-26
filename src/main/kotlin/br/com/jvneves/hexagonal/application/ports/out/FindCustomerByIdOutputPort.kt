package br.com.jvneves.hexagonal.application.ports.out

import br.com.jvneves.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?
}