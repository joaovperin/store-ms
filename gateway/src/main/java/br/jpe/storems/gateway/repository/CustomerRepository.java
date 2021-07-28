package br.jpe.storems.gateway.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.jpe.storems.gateway.domain.CustomerResponse;

@FeignClient(name = "customer", url = "http://localhost:8091/v1/customer")
public interface CustomerRepository {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<CustomerResponse> list();

}
