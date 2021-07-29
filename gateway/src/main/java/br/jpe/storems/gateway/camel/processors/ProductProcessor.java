package br.jpe.storems.gateway.camel.processors;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.jpe.storems.gateway.domain.OrderResponse;
import br.jpe.storems.gateway.domain.ProductResponse;

public class ProductProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		List<ProductResponse> products = exchange.getIn().getBody(List.class);
		exchange.setProperty("product", products);

		List<OrderResponse> orders = exchange.getProperty("order", List.class);
		orders.parallelStream().forEach(e -> setProductOnOrderItems(e, products));

		exchange.getIn().setBody(orders);
	}

	void setProductOnOrderItems(OrderResponse order, List<ProductResponse> products) {
		order.getItems().parallelStream().forEach(item -> {
			item.setProduct(products.stream().filter(c -> c.getId() == item.getProductId()).findAny().orElse(null));
		});
	}

}
