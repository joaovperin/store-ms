package br.jpe.storems.customers.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.jpe.storems.customers.domain.Customer;
import br.jpe.storems.customers.repository.CustomerRepository;

@Component
public class CustomerInitializer implements ApplicationRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var list = List.of(Customer.builder().name("john doe").email("jhon.doe@mail.com").build(),
				Customer.builder().name("foo bar").email("foo.bar@mail.com").build());
		customerRepository.saveAll(list);
	}

}
