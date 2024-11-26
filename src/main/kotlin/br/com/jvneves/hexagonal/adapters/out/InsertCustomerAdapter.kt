package br.com.jvneves.hexagonal.adapters.out

import br.com.jvneves.hexagonal.adapters.out.repository.CustomerRepository
import br.com.jvneves.hexagonal.adapters.out.repository.entity.CustomerEntity
import br.com.jvneves.hexagonal.application.core.domain.Customer
import br.com.jvneves.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
            customerRepository.save(CustomerEntity(customer))
    }
}