package br.com.jvneves.hexagonal.application.core.services

import br.com.jvneves.hexagonal.application.core.exceptions.ObjectNotFoundException
import br.com.jvneves.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.jvneves.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdService(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")


}