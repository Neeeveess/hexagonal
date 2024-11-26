package br.com.jvneves.hexagonal.adapters.out.client.response

import br.com.jvneves.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
){
    fun toAddress() = Address(street,city,state)
}
