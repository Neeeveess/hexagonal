package br.com.jvneves.hexagonal.application.core.services

import br.com.jvneves.hexagonal.application.core.domain.Customer
import br.com.jvneves.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.com.jvneves.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.jvneves.hexagonal.application.ports.out.InsertCustomerOutputPort
import br.com.jvneves.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerService(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}