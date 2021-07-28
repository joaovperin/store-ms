package br.jpe.storems.orders.config;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.jpe.storems.orders.domain.Order;
import br.jpe.storems.orders.domain.OrderItem;
import br.jpe.storems.orders.repository.OrderRepository;

@Component
public class OrderInitializer implements ApplicationRunner {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var list = List.of(Order.builder().customerId(1L).totalValue(BigDecimal.valueOf(100))
				.entryDate(ZonedDateTime.now())
				.items(Set.of(
						OrderItem.builder().orderId(1L).sequence(1).productId(100L).quantity(BigDecimal.ONE)
								.unitValue(BigDecimal.ONE).totalValue(BigDecimal.ONE).build(),
						OrderItem.builder().orderId(1L).sequence(2).productId(102L).quantity(BigDecimal.valueOf(5))
								.unitValue(BigDecimal.TEN).totalValue(BigDecimal.valueOf(50)).build()))
				.build(),
				Order.builder().customerId(3L).totalValue(BigDecimal.valueOf(20))
						.entryDate(ZonedDateTime.now().minus(Duration.ofDays(3)))
						.items(Set
								.of(OrderItem.builder().orderId(2L).sequence(1).productId(105L).quantity(BigDecimal.TEN)
										.unitValue(BigDecimal.valueOf(2)).totalValue(BigDecimal.valueOf(20)).build()))
						.build());
		orderRepository.saveAll(list);
	}

}
