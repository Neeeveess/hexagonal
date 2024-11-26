package br.com.jvneves.hexagonal.adapters.out

import br.com.jvneves.hexagonal.adapters.out.repository.CustomerRepository
import br.com.jvneves.hexagonal.application.core.domain.Customer
import br.com.jvneves.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }
}