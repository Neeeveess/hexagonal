package br.com.jvneves.hexagonal.application.core.services

import br.com.jvneves.hexagonal.application.core.domain.Customer
import br.com.jvneves.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.jvneves.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.jvneves.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.jvneves.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import br.com.jvneves.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerService(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("The id field cannot be null")
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}