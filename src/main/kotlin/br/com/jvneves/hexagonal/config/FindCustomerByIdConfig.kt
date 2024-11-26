package br.com.jvneves.hexagonal.config

import br.com.jvneves.hexagonal.adapters.out.FindCustomerByIdAdapter
import br.com.jvneves.hexagonal.application.core.services.FindCustomerByIdService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
        FindCustomerByIdService(findCustomerByIdAdapter)

}