package br.jpe.storems.customers.application.ports.in;

import java.util.Optional;

import br.jpe.storems.customers.domain.Customer;

public interface FindCustomerByIdUseCase {

	Optional<Customer> findById(Long id);

}
