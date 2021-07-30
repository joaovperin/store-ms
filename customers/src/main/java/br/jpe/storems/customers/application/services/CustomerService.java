package br.jpe.storems.customers.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jpe.storems.customers.adapters.out.CustomerJpaEntity;
import br.jpe.storems.customers.adapters.out.CustomerPersistenceAdapter;
import br.jpe.storems.customers.adapters.out.CustomerRepository;
import br.jpe.storems.customers.application.ports.in.FindCustomerByIdUseCase;
import br.jpe.storems.customers.application.ports.in.FindCustomersUseCase;
import br.jpe.storems.customers.application.ports.in.SaveCustomerUseCase;
import br.jpe.storems.customers.domain.Customer;

@Component
public class CustomerService implements FindCustomerByIdUseCase, FindCustomersUseCase, SaveCustomerUseCase {

	@Autowired
	private CustomerRepository repository;
	@Autowired
	private CustomerPersistenceAdapter persistenceAdapter;

	@Override
	public List<Customer> findCustomers() {
		return repository.findAll().parallelStream()
				.map(e -> persistenceAdapter.toDomainEntity(e))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return repository.findById(id)
				.map(e -> persistenceAdapter.toDomainEntity(e));
	}

	@Override
	public Customer save(Customer customer) {
		CustomerJpaEntity jpaEntity = repository.save(
				persistenceAdapter.fromDomainEntity(customer));
		return persistenceAdapter.toDomainEntity(jpaEntity);
	}

}
