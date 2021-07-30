package br.jpe.storems.customers.application.ports.in;

import br.jpe.storems.customers.domain.Customer;

public interface SaveCustomerUseCase {

	Customer save(Customer customer);

}
