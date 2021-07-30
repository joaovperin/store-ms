package br.jpe.storems.customers.application.ports.in;

import java.util.List;

import br.jpe.storems.customers.domain.Customer;

public interface FindCustomersUseCase {

	List<Customer> findCustomers();

}
