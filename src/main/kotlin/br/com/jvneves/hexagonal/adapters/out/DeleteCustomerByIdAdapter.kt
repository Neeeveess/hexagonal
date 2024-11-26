package br.com.jvneves.hexagonal.adapters.out

import br.com.jvneves.hexagonal.adapters.out.repository.CustomerRepository
import br.com.jvneves.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : DeleteCustomerByIdOutputPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}