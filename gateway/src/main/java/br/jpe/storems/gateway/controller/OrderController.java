package br.jpe.storems.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jpe.storems.gateway.service.OrderService;

@RequestMapping("v1/order")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<?>> list() {
		var list = orderService.list();
		return ResponseEntity.ok(list);
	}
}
