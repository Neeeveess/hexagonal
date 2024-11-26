package br.com.jvneves.hexagonal.adapters.out

import br.com.jvneves.hexagonal.adapters.out.repository.CustomerRepository
import br.com.jvneves.hexagonal.adapters.out.repository.entity.CustomerEntity
import br.com.jvneves.hexagonal.application.core.domain.Customer
import br.com.jvneves.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort {
    
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}