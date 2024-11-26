package br.com.jvneves.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}