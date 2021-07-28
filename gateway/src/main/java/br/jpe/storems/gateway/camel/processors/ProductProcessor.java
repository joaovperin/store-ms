package br.jpe.storems.gateway.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class ProductProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		List body = exchange.getIn().getBody(List.class);
		exchange.setProperty("product", body);
		exchange.getIn().setBody(body);
		exchange.getMessage().setBody(body);
	}

}
