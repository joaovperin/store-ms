package br.jpe.storems.gateway.service;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jpe.storems.gateway.camel.GatewayCamelRouter;
import br.jpe.storems.gateway.domain.OrderResponse;

@Service
public class OrderService {

	@Autowired
	ProducerTemplate template;

	public List list() {
		return template.requestBody(GatewayCamelRouter.ORDER, null, List.class);
	}

}
