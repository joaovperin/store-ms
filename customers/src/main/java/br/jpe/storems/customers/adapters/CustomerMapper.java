package br.jpe.storems.customers.adapters;

import org.springframework.stereotype.Component;

import br.jpe.storems.customers.application.ports.in.CustomerInput;
import br.jpe.storems.customers.application.ports.out.CustomerOutput;
import br.jpe.storems.customers.domain.Customer;

@Component
public class CustomerMapper {
	
	public Customer fromInput(CustomerInput inputEntity) {
		return Customer.builder()
				.name(inputEntity.getName())
				.email(inputEntity.getEmail())
				.build()
				.withAge(inputEntity.getAge());
	}
	
	public CustomerOutput toOutput(Customer domainEntity) {
		return CustomerOutput.builder()
				.id(domainEntity.getId())
				.name(domainEntity.getName())
				.age(domainEntity.getAge())
				.email(domainEntity.getEmail())
				.build();
	}
	
}
