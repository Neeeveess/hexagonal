package br.com.jvneves.hexagonal.adapters.out

import br.com.jvneves.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import br.com.jvneves.hexagonal.application.core.domain.Address
import br.com.jvneves.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
         findAddressByZipCodeClient.find(zipCode).toAddress()
}