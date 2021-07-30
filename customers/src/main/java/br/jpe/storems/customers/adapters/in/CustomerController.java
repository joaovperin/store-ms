package br.jpe.storems.customers.adapters.in;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jpe.storems.customers.adapters.CustomerMapper;
import br.jpe.storems.customers.application.ports.in.CustomerInput;
import br.jpe.storems.customers.application.ports.in.FindCustomerByIdUseCase;
import br.jpe.storems.customers.application.ports.in.FindCustomersUseCase;
import br.jpe.storems.customers.application.ports.in.SaveCustomerUseCase;
import br.jpe.storems.customers.application.ports.out.CustomerOutput;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerMapper mapper;

	@Autowired
	private FindCustomerByIdUseCase findCustomerByIdUseCase;
	@Autowired
	private FindCustomersUseCase findCustomersUseCase;
	@Autowired
	private SaveCustomerUseCase saveCustomerUseCase;

	@GetMapping
	public ResponseEntity<List<CustomerOutput>> findCustomers() {
		return ResponseEntity.ok(findCustomersUseCase.findCustomers()
				.parallelStream()
				.map(mapper::toOutput)
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerOutput> findById(@PathVariable Long id) {
		var result = findCustomerByIdUseCase.findById(id).map(mapper::toOutput);
		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<CustomerOutput> save(@RequestBody CustomerInput data) {
		return ResponseEntity.ok(mapper.toOutput(
				saveCustomerUseCase.save(mapper.fromInput(data))));
	}

}
