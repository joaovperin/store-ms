package br.jpe.storems.gateway.camel.processors;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class OrderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message input = exchange.getIn();
		var body = input.getBody(ArrayList.class);
		exchange.setProperty("order", body);
	}

}
