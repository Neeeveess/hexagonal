package br.com.jvneves.hexagonal.application.ports.out

import br.com.jvneves.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}