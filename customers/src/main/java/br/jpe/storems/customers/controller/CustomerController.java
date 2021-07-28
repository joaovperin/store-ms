package br.jpe.storems.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jpe.storems.customers.domain.Customer;
import br.jpe.storems.customers.repository.CustomerRepository;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@GetMapping
	public ResponseEntity<List<Customer>> findCustomers() {
		var list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		var result = repository.findById(id);
		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.notFound().build();
	}

}
