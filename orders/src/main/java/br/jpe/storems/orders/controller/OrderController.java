package br.jpe.storems.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jpe.storems.orders.domain.Order;
import br.jpe.storems.orders.repository.OrderRepository;

@RestController
@RequestMapping("v1/order")
public class OrderController {

	@Autowired
	private OrderRepository repository;

	@GetMapping
	public ResponseEntity<List<Order>> findCustomers() {
		var list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		var result = repository.findById(id);
		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.notFound().build();
	}

}
