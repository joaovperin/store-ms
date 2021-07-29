package br.jpe.storems.gateway.camel.processors;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.jpe.storems.gateway.domain.CustomerResponse;
import br.jpe.storems.gateway.domain.OrderResponse;

public class CustomerProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		List<CustomerResponse> customers = exchange.getIn().getBody(List.class);
		exchange.setProperty("customer", customers);

		List<OrderResponse> orders = exchange.getProperty("order", List.class);

		orders.parallelStream().forEach(e -> setCustomerOnOrder(e, customers));
		exchange.getMessage().setBody(orders);
	}

	void setCustomerOnOrder(OrderResponse order, List<CustomerResponse> customers) {
		order.setCustomer(customers.stream().filter(c -> c.getId() == order.getCustomerId()).findAny().orElse(null));
	}

}
