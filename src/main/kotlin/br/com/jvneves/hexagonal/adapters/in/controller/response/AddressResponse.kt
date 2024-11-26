package br.com.jvneves.hexagonal.adapters.`in`.controller.response

import br.com.jvneves.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state
    )
}
