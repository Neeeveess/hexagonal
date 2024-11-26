package br.com.jvneves.hexagonal.adapters.`in`.consumer.message

import br.com.jvneves.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
) {
    fun toCustomer() = Customer(id, name, cpf = cpf, isValidCpf = isValidCpf)
}