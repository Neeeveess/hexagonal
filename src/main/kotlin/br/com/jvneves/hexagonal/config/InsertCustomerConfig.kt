package br.com.jvneves.hexagonal.config

import br.com.jvneves.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import br.com.jvneves.hexagonal.adapters.out.InsertCustomerAdapter
import br.com.jvneves.hexagonal.adapters.out.SendCpfForValidationAdapter
import br.com.jvneves.hexagonal.application.core.services.InsertCustomerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = InsertCustomerService(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter)


}