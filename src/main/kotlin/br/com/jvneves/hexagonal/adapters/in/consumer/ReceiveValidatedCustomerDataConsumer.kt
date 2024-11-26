package br.com.jvneves.hexagonal.adapters.`in`.consumer

import br.com.jvneves.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import br.com.jvneves.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "jv_neves")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }
}