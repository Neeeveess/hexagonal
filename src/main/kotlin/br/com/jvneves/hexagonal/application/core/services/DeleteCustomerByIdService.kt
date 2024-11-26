package br.com.jvneves.hexagonal.application.core.services

import br.com.jvneves.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import br.com.jvneves.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.jvneves.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdService(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) : DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}