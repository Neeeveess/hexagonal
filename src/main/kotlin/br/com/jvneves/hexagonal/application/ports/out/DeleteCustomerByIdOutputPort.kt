package br.com.jvneves.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {

    fun delete(id: String)
}