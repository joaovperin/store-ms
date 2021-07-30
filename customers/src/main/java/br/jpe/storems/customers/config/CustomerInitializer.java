package br.jpe.storems.customers.config;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.jpe.storems.customers.adapters.out.CustomerJpaEntity;
import br.jpe.storems.customers.adapters.out.CustomerRepository;
import br.jpe.storems.customers.domain.Customer;

@Component
public class CustomerInitializer implements ApplicationRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var list = List.of(CustomerJpaEntity.builder().name("john doe").email("jhon.doe@mail.com").dateOfBirth(ZonedDateTime.now().minusYears(20)).build(),
				CustomerJpaEntity.builder().name("foo bar").email("foo.bar@mail.com").dateOfBirth(ZonedDateTime.now().minusYears(32)).build());
		customerRepository.saveAll(list);
	}

}
