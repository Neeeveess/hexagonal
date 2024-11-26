package br.com.jvneves.hexagonal.config

import br.com.jvneves.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import br.com.jvneves.hexagonal.application.core.services.DeleteCustomerByIdService
import br.com.jvneves.hexagonal.application.core.services.FindCustomerByIdService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdService: FindCustomerByIdService,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdService(findCustomerByIdService, deleteCustomerByIdAdapter)
}