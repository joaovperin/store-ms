package br.jpe.storems.gateway.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.jpe.storems.gateway.domain.OrderResponse;

@FeignClient(name = "order", url = "http://localhost:8093/v1/order")
public interface OrderRepository {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<OrderResponse> list();

}
