package br.jpe.storems.gateway.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jpe.storems.gateway.camel.processors.CustomerProcessor;
import br.jpe.storems.gateway.camel.processors.OrderProcessor;
import br.jpe.storems.gateway.camel.processors.ProductProcessor;
import br.jpe.storems.gateway.repository.CustomerRepository;
import br.jpe.storems.gateway.repository.OrderRepository;
import br.jpe.storems.gateway.repository.ProductRepository;

@Component
public class GatewayCamelRouter extends RouteBuilder {

	public static final String CUSTOMER = "direct:customer";
	public static final String PRODUCT = "direct:product";
	public static final String ORDER = "direct:order";

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void configure() throws Exception {
		// Customer route
		from(GatewayCamelRouter.CUSTOMER).bean(customerRepository, "list()")
				.log(LoggingLevel.DEBUG, "---> Customer ${body}").end();
		// Product route
		from(GatewayCamelRouter.PRODUCT).bean(productRepository, "list()")
				.log(LoggingLevel.DEBUG, "---> Product ${body}").end();
		// Order route
		from(GatewayCamelRouter.ORDER).bean(orderRepository, "list()").log(LoggingLevel.DEBUG, "-------> ${body}")
				.process(new OrderProcessor()).log(LoggingLevel.DEBUG, "-> ${body}").to(GatewayCamelRouter.CUSTOMER)
				.process(new CustomerProcessor()).log(LoggingLevel.DEBUG, "-> (Order-Customer) ${body}")
				.to(GatewayCamelRouter.PRODUCT).process(new ProductProcessor())
				.log(LoggingLevel.DEBUG, "-> (Order-Product) ${body}").log(LoggingLevel.DEBUG, "-> ${body}").end();
	}

}
