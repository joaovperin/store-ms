package br.jpe.storems.gateway.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.jpe.storems.gateway.domain.ProductResponse;

@FeignClient(name = "product", url = "http://localhost:8092/v1/product")
public interface ProductRepository {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<ProductResponse> list();

}
