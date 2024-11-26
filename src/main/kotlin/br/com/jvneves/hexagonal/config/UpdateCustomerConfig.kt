package br.com.jvneves.hexagonal.config

import br.com.jvneves.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import br.com.jvneves.hexagonal.adapters.out.SendCpfForValidationAdapter
import br.com.jvneves.hexagonal.adapters.out.UpdateCustomerAdapter
import br.com.jvneves.hexagonal.application.core.services.FindCustomerByIdService
import br.com.jvneves.hexagonal.application.core.services.UpdateCustomerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun UpdateCustomer(
        findCustomerByIdService: FindCustomerByIdService,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) =
        UpdateCustomerService(
            findCustomerByIdService,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter,
            sendCpfForValidationAdapter
        )

}