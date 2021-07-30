package br.jpe.storems.customers.adapters.out;

import org.springframework.stereotype.Component;

import br.jpe.storems.customers.domain.Customer;

@Component
public class CustomerPersistenceAdapter {

	public Customer toDomainEntity(CustomerJpaEntity jpaEntity) {
		return Customer.builder()
				.id(jpaEntity.getId())
				.name(jpaEntity.getName())
				.dateOfBirth(jpaEntity.getDateOfBirth())
				.email(jpaEntity.getEmail())
				.build();
	}
	
	public CustomerJpaEntity fromDomainEntity(Customer domainEntity) {
		return CustomerJpaEntity.builder()
				.id(domainEntity.getId())
				.name(domainEntity.getName())
				.dateOfBirth(domainEntity.getDateOfBirth())
				.email(domainEntity.getEmail())
				.build();
	}
	
}
