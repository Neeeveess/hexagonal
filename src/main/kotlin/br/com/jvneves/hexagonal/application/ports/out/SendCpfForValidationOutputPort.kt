package br.com.jvneves.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}